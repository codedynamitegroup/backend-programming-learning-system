package com.backend.programming.learning.system.domain.valueobject;

public enum WebhookEventName {
    COURSE_CREATED("\\core\\event\\course_created"),
    COURSE_UPDATED("\\core\\event\\course_updated"),
    COURSE_DELETED("\\core\\event\\course_deleted"),

    COURSE_SECTION_CREATED("\\core\\event\\course_section_created"),
    COURSE_SECTION_UPDATED("\\core\\event\\course_section_updated"),
    COURSE_SECTION_DELETED("\\core\\event\\course_section_deleted"),

    COURSE_MODULE_CREATED("\\core\\event\\course_module_created"),
    COURSE_MODULE_UPDATED("\\core\\event\\course_module_updated"),
    COURSE_MODULE_DELETED("\\core\\event\\course_module_deleted"),


    ASSIGN_SUBMISSION_FILE_CREATED("\\assignsubmission_file\\event\\submission_created"),
    ASSIGN_SUBMISSION_FILE_UPDATED("\\assignsubmission_file\\event\\submission_updated"),

    ASSIGN_SUBMISSION_ONLINETEXT_CREATED("\\assignsubmission_onlinetext\\event\\submission_created"),
    ASSIGN_SUBMISSION_ONLINETEXT_UPDATED("\\assignsubmission_onlinetext\\event\\submission_updated"),

    USER_CREATED("\\core\\event\\user_created"),
    USER_UPDATED("\\core\\event\\user_updated"),
    USER_DELETED("\\core\\event\\user_deleted"),

    USER_ENROLLMENT_CREATED("\\core\\event\\user_enrolment_created"),
    USER_ENROLLMENT_UPDATED("\\core\\event\\user_enrolment_updated"),
    USER_ENROLLMENT_DELETED("\\core\\event\\user_enrolment_deleted"),

    ROLE_ASSIGNED("\\core\\event\\role_assigned");

//    ENROL_INSTANCE_CREATED("\\core\\event\\enrol_instance_created"),
//    ENROL_INSTANCE_UPDATED("\\core\\event\\enrol_instance_updated"),
//    ENROL_INSTANCE_DELETED("\\core\\event\\enrol_instance_deleted");

    public final String label;

    private WebhookEventName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
