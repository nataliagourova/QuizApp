package com.example.quizapp.data;

import android.content.Context;

import com.example.quizapp.data.model.QuestionCategory;
import com.example.quizapp.data.model.YesNoQuestion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockOpenTrivia {

    private List<QuestionCategory> categories;
    private List<YesNoQuestion> questions;

    private MockOpenTrivia(List<QuestionCategory> categories, List<YesNoQuestion> questions) {
        this.categories = categories;
        this.questions = questions;
    }

    public List<QuestionCategory> getCategories() {
        return categories;
    }

    public List<YesNoQuestion> getYesNoQuestions(int numberOfQuestions, QuestionCategory category) {
        List<YesNoQuestion> questionForCategory = new ArrayList<>(questions);
        Collections.shuffle(questionForCategory);
        return questionForCategory;
    }

    public static MockOpenTrivia loadFromAssets(Context context) {
        try {
            List<QuestionCategory> categories = parseMockCategories(loadMockCategoriesJson(context));
            List<YesNoQuestion> questions = parseMockQuestions(loadMockQuestionsJson(context));

            return new MockOpenTrivia(categories, questions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    private static List<QuestionCategory> parseMockCategories(String mockCategoriesJson) throws JSONException {
        JSONObject obj = new JSONObject(mockCategoriesJson);
        JSONArray categoriesJsonArr = obj.getJSONArray("trivia_categories");

        List<QuestionCategory> categories = new ArrayList<>(categoriesJsonArr.length());

        for (int i = 0; i < categoriesJsonArr.length(); i++) {
            categories.add(QuestionCategory.fromJson(categoriesJsonArr.getJSONObject(i)));
        }
        return categories;
    }

    private static List<YesNoQuestion> parseMockQuestions(String mockQuestionsJson) throws JSONException {
        JSONObject obj = new JSONObject(mockQuestionsJson);
        JSONArray questionsJsonArr = obj.getJSONArray("results");

        List<YesNoQuestion> questions = new ArrayList<>(questionsJsonArr.length());

        for (int i = 0; i < questionsJsonArr.length(); i++) {
            questions.add(YesNoQuestion.fromJson(questionsJsonArr.getJSONObject(i)));
        }
        return questions;
    }
}
