package com.backend.programming.learning.system.domain.valueobject;

public enum WebhookEventName {
    COURSE_CREATED("\\core\\event\\course_created"),
    COURSE_UPDATED("\\core\\event\\course_deleted"),
    COURSE_DELETED("\\core\\event\\course_updated"),

    COURSE_SECTION_CREATED("\\core\\event\\course_section_created"),
    COURSE_SECTION_UPDATED("\\core\\event\\course_section_updated"),
    COURSE_SECTION_DELETED("\\core\\event\\course_section_deleted"),

    COURSE_MODULE_CREATED("\\core\\event\\course_module_created"),
    COURSE_MODULE_UPDATED("\\core\\event\\course_module_updated"),
    COURSE_MODULE_DELETED("\\core\\event\\course_module_deleted"),

    USER_CREATED("\\core\\event\\user_created"),
    USER_UPDATED("\\core\\event\\user_updated"),
    USER_DELETED("\\core\\event\\user_deleted"),

    USER_ENROLLMENT_CREATED("\\core\\event\\user_enrolment_created"),

    ROLE_ASSIGNED("\\core\\event\\role_assigned"),

    ENROL_INSTANCE_CREATED("\\core\\event\\enrol_instance_created"),
    ENROL_INSTANCE_UPDATED("\\core\\event\\enrol_instance_updated"),
    ENROL_INSTANCE_DELETED("\\core\\event\\enrol_instance_deleted");

    public final String label;

    private WebhookEventName(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
