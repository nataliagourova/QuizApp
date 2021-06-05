package com.example.quizapp.data.model;

import org.json.JSONObject;

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

    public static QuestionCategory fromJson(JSONObject json) {
        try {
            return new QuestionCategory(json.getInt("id"), json.getString("name"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
