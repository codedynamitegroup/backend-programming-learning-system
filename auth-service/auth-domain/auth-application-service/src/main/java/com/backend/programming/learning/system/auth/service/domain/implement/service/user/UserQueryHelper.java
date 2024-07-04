package com.backend.programming.learning.system.auth.service.domain.implement.service.user;

import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryGeneralStatisticUserResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryLineChartResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.method.query.user.QueryPieChartResponse;
import com.backend.programming.learning.system.auth.service.domain.dto.response_entity.user.UserEntityResponse;
import com.backend.programming.learning.system.auth.service.domain.entity.Role;
import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.exception.AuthNotFoundException;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.RoleRepository;
import com.backend.programming.learning.system.auth.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UserQueryHelper {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserQueryHelper(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Transactional(readOnly = true)
    public User queryUser(UUID userId) {
        Optional<User> userResult =
                userRepository.findById(new UserId(userId));
        if (userResult.isEmpty()) {
            log.warn("Could not find user with id: {}", userId);
            throw new AuthNotFoundException("Could not find user with user id: " +
                    userId);
        }
        return userResult.get();
    }

    @Transactional(readOnly = true)
    public Page<User> queryAllUsers(Integer pageNo, Integer pageSize, String searchName, String belongToOrg) {
        return userRepository.findAll(pageNo, pageSize, searchName, belongToOrg);
    }

    @Transactional(readOnly = true)
    public Page<User> queryAllUsersByOrganization(UUID organizationId, Integer pageNo, Integer pageSize, String searchName) {
        return userRepository.findAllUsersByOrganization(organizationId, pageNo, pageSize, searchName);
    }

    @Transactional(readOnly = true)
    public User queryUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.warn("Could not find user with email: {}", email);
                    return new AuthNotFoundException("Could not find user with email: " +
                            email);
                });
    }

    @Transactional(readOnly = true)
    public User queryUserByEmailAndIsDeletedTrueOrFalse(String email) {
        return userRepository.findByEmailAndIsDeletedTrueOrFalse(email)
                .orElseThrow(() -> {
                    log.warn("Could not find user with email: {}", email);
                    return new AuthNotFoundException("Could not find user with email: " +
                            email);
                });
    }

    @Transactional(readOnly = true)
    public User queryUserByIdAndIsDeletedTrueOrFalse(UUID userId) {
        return userRepository.findByIdAndIsDeletedTrueOrFalse(new UserId(userId))
                .orElseThrow(() -> {
                    log.warn("Could not find user with userId: {}", userId);
                    return new AuthNotFoundException("Could not find user with userId: " +
                            userId);
                });
    }

    @Transactional(readOnly = true)
    public QueryGeneralStatisticUserResponse getStatisticUser() {
        List<User> users = userRepository.findAll(0, 100000, "", "ALL").getContent();
        List<Role> roles = roleRepository.findAll(0, 100000).getContent();

        long activeUser = calculateActiveUsers(users);

        return QueryGeneralStatisticUserResponse.builder()
                .totalUsers(users.size())
                .activeUsers(activeUser)
                .offlineUsers(users.size() - activeUser)
                .loginToday(calculateLoginToday(users))
                .userByRole(calculateUserRole(users, roles))
                .registerUser(calculateRegisterUser(users))
                .build();
    }

    public QueryGeneralStatisticUserResponse getStatisticUserAdminOrg(String orgId) {
        List<User> users = userRepository
                .findAll(0, 100000, "", "ALL")
                .getContent()
                .stream()
                .filter(user -> Objects.nonNull(user.getOrganization()) && user.getOrganization().getId().getValue().toString().equals(orgId))
                .collect(Collectors.toList());

        List<Role> roles = roleRepository.findAll(0, 100000).getContent();

        long activeUser = calculateActiveUsers(users);

        return QueryGeneralStatisticUserResponse.builder()
                .totalUsers(users.size())
                .activeUsers(activeUser)
                .offlineUsers(users.size() - activeUser)
                .loginToday(calculateLoginToday(users))
                .userByRole(calculateUserRole(users, roles))
                .registerUser(calculateRegisterUser(users))
                .build();
    }

    private long calculateActiveUsers(List<User> users) {
        long accessTokenExpTimeInMinutes = 15; // replace with your actual value

        return users.stream()
                .filter(user -> {
                    ZonedDateTime lastLogin = user.getLastLogin();
                    ZonedDateTime currentDate = ZonedDateTime.now();
                    long differenceInMinutes = Duration.between(lastLogin, currentDate).toMinutes();

                    return differenceInMinutes <= accessTokenExpTimeInMinutes;
                })
                .count();
    }

    private List<QueryPieChartResponse> calculateUserRole(List<User> users, List<Role> roles) {
           int[] roleData = new int[roles.size()];

           users.forEach(user -> {
               Set<Role> role = user.getRoles();

               role.forEach(roleInList ->{
                   roleData[roles.indexOf(roleInList)]++;
               });
            });

         List<QueryPieChartResponse> result = new ArrayList<>();
         for (int i = 0; i < roles.size(); i++) {
              result.add(QueryPieChartResponse.builder()
                     .index(i)
                      .label(roles.get(i).getName())
                     .value(roleData[i])
                     .build());
         }

        return result;
    }

    private long calculateLoginToday(List<User> users) {
        return users.stream()
                .filter(user -> {
                    ZonedDateTime lastLogin = user.getLastLogin();
                    ZonedDateTime currentDate = ZonedDateTime.now();
                    return lastLogin.getDayOfYear() == currentDate.getDayOfYear() &&
                            lastLogin.getYear() == currentDate.getYear() &&
                            lastLogin.getMonth() == currentDate.getMonth();
                })
                .count();
    }

    private List<QueryLineChartResponse> calculateRegisterUser(List<User> users) {
        if(users.isEmpty()) {
            return new ArrayList<>();
        }

        List<QueryLineChartResponse> result = new ArrayList<>();
        QueryLineChartResponse filterByDaysInWeek = null;
        QueryLineChartResponse filterByDaysInMonth = null;
        QueryLineChartResponse filterByDaysInYear = null;

        final long[] daysInWeekRegisterData = new long[7];
        final long[] daysInMonthRegisterData = new long[ZonedDateTime.now().getMonth().length(ZonedDateTime.now().toLocalDate().isLeapYear())];
        final long[] daysInYearRegisterData = new long[12];

        // Days in week
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() ||
                    registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }

            long differenceInDays = Duration.between(registerDate, currentDate).toDays();

            if(differenceInDays <= 7) {
                daysInWeekRegisterData[registerDate.getDayOfWeek().getValue() - 1]++;
            }
        });

        filterByDaysInWeek = QueryLineChartResponse.builder()
                .label("New user")
                .data(daysInWeekRegisterData)
                .build();

        // Days in month
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear() || registerDate.getMonth() != currentDate.getMonth()) {
                return;
            }
            daysInMonthRegisterData[registerDate.getDayOfMonth() - 1]++;
        });

        filterByDaysInMonth = QueryLineChartResponse.builder()
                .label("New user")
                .data(daysInMonthRegisterData)
                .build();

        // Days in year
        users.forEach(user -> {
            ZonedDateTime registerDate = user.getCreatedAt();
            ZonedDateTime currentDate = ZonedDateTime.now();

            if(registerDate.getYear() != currentDate.getYear()) {
                return;
            }
            daysInYearRegisterData[registerDate.getMonth().getValue() - 1]++;
        });
        filterByDaysInYear = QueryLineChartResponse.builder()
                .label("New user")
                .data(daysInYearRegisterData)
                .build();

        result.add(filterByDaysInWeek);
        result.add(filterByDaysInMonth);
        result.add(filterByDaysInYear);

        return result;
    }

}





















