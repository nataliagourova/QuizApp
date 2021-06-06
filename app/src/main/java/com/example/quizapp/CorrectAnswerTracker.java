package com.example.quizapp;

public interface CorrectAnswerTracker {
    void onQuestionAnswered(int position, boolean isCorrect);
}
