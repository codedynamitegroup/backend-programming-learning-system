package com.backend.programming.learning.system.course.service.domain.valueobject;

public enum TypeModule {
    ASSIGNMENT("Assignments"),

    FILE("Files"),

    URL("URLs"),

    QUIZ("Quizzes");


    public String label;

    TypeModule(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TypeModule fromLabel(String label) {
        for (TypeModule type : TypeModule.values()) {
            if (type.getLabel().equals(label)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }

}
