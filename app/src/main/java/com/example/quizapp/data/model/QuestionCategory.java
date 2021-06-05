package com.example.quizapp.data.model;

public class QuestionCategory {
    private int id;
    private String name;

    private QuestionCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static QuestionCategory fromJson(String json) {
        return null;
    }
}
