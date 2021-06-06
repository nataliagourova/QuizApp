package com.example.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.data.MockOpenTrivia;
import com.example.quizapp.data.model.QuestionCategory;
import com.example.quizapp.data.model.YesNoQuestion;
import com.example.quizapp.ui.QuestionsRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_EXTRA = "name_extra";

    private TextView welcomeText;
    private MockOpenTrivia mockOpenTrivia;
    private Spinner categoriesSpinner;
    private RecyclerView questionsRecyclerView;
    private QuestionsRecyclerViewAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        welcomeText.setText("Welcome " + getIntent().getStringExtra(NAME_EXTRA));
        mockOpenTrivia = MockOpenTrivia.loadFromAssets(this);
        categoriesSpinner.setAdapter(
                new ArrayAdapter<>(this, R.layout.category_spinner_item, mockOpenTrivia.getCategories()));
        categoriesSpinner.setOnItemSelectedListener(selectCategory(this));

        questionsAdapter = new QuestionsRecyclerViewAdapter();
        questionsRecyclerView.setAdapter(questionsAdapter);
    }

    private void findViews() {
        welcomeText = findViewById(R.id.main_welcome_txt);
        categoriesSpinner = findViewById(R.id.categories_spin);
        questionsRecyclerView = findViewById(R.id.questions_recycler_view);
    }

    private AdapterView.OnItemSelectedListener selectCategory(Context context) {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                QuestionCategory selectedCategory = (QuestionCategory) parent.getItemAtPosition(position);
                Toast.makeText(context, selectedCategory.getName(), Toast.LENGTH_SHORT).show();
                populateQuestions(selectedCategory);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(context, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void populateQuestions(QuestionCategory category) {
        List<YesNoQuestion> questions = mockOpenTrivia.getYesNoQuestions(10, category);
        questionsAdapter.setQuestions(questions);

    }
}