package com.backend.programming.learning.system.course.service.domain.dto.method.ai_grade_essay;

import java.util.ArrayList;

public class AIGradeEssayCommand {
    public ArrayList<Content> contents;
}

 class Content {
    public String role;
    public ArrayList<Part> parts;
}

class Part{
    public String text;
}
