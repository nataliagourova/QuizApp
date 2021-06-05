package com.example.quizapp.data.model;

import org.json.JSONObject;

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

    public static YesNoQuestion fromJson(JSONObject json) {
        try {
            return new YesNoQuestion(
                    json.getString("correct_answer").equals("True"),
                    json.getString("category"),
                    json.getString("question")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
