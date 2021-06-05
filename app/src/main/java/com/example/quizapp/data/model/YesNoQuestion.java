package com.example.quizapp.data.model;

public class YesNoQuestion {
    private boolean isTrue;
    private String categoryName;
    private String questionText;

    private YesNoQuestion(boolean isTrue, String categoryName, String questionText) {
        this.isTrue = isTrue;
        this.categoryName = categoryName;
        this.questionText = questionText;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getQuestionText() {
        return questionText;
    }

    public static YesNoQuestion fromJson(String json) {
        return null;
    }
}
