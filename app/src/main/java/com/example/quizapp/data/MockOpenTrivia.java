package com.example.quizapp.data;

import android.content.Context;

import com.example.quizapp.data.model.QuestionCategory;
import com.example.quizapp.data.model.YesNoQuestion;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MockOpenTrivia {

    private List<QuestionCategory> categories;
    private List<YesNoQuestion> questions;

    private MockOpenTrivia(List<QuestionCategory> categories, List<YesNoQuestion> questions) {
        this.categories = categories;
        this.questions = questions;
    }

    public static MockOpenTrivia loadFromAssets(Context context) {
        try {
            String categoriesJson = loadMockCategoriesJson(context);
            String questionsJson = loadMockQuestionsJson(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new MockOpenTrivia(null, null);
    }

    private static String loadMockCategoriesJson(Context context) throws IOException {
        InputStream is = context.getAssets().open("mock_categories.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }

    private static String loadMockQuestionsJson(Context context) throws IOException {
        InputStream is = context.getAssets().open("mock_yes_no_questions.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }

    public List<QuestionCategory> getCategories() {
        return categories;
    }

    public List<YesNoQuestion> getYesNoQuestions(int numberOfQuestions) {
        return questions;
    }
}
