package com.backend.programming.learning.system.auth.service.application.rest.file;

import com.backend.programming.learning.system.course.service.domain.dto.method.download.DownloadFileResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.file.FileApplicationService;
import com.backend.programming.learning.system.domain.valueobject.FileType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course/file", produces = "application/vnd.api.v1+json")
public class FileController {
    private final FileApplicationService fileApplicationService;

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation(summary = "Download file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/octet-stream",
                            schema = @Schema(implementation = Resource.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Resource> downloadFile(
            @RequestParam(name = "fileId") String fileId,
            @RequestParam(name = "token") String token
    ) {
        DownloadFileResponse downloadedFile = fileApplicationService.downloadFile(fileId, token);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + downloadedFile.getFileName() + "\"");
        headers.add(HttpHeaders.CONTENT_TYPE, downloadedFile.getFileType());

        headers.setAccessControlExposeHeaders(
                Arrays.asList(
                        HttpHeaders.CONTENT_DISPOSITION,
                        HttpHeaders.CONTENT_TYPE
                )
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(downloadedFile.getFileData());
    }

    @GetMapping(value = "/export/grade", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Operation(summary = "Export grade from a specific course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success.", content = {
                    @Content(mediaType = "application/octet-stream",
                            schema = @Schema(implementation = Resource.class))
            }),
            @ApiResponse(responseCode = "400", description = "Not found."),
            @ApiResponse(responseCode = "500", description = "Unexpected error.")})
    public ResponseEntity<Resource> exportGrade(
            @RequestParam(name = "courseId") String courseId,
            @RequestParam(name = "fileType") FileType fileType
    ) {
        DownloadFileResponse exportedGradeFile = fileApplicationService.exportGrade(courseId, fileType);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "course_grade_" + currentDateTime + "\"");
        headers.add(HttpHeaders.CONTENT_TYPE, exportedGradeFile.getFileType());

        headers.setAccessControlExposeHeaders(
                Arrays.asList(
                        HttpHeaders.CONTENT_DISPOSITION,
                        HttpHeaders.CONTENT_TYPE
                )
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(exportedGradeFile.getFileData());
    }
}
