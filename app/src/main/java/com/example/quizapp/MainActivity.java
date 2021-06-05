package com.example.quizapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_EXTRA = "name_extra";

    private TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        welcomeText.setText("Welcome " + getIntent().getStringExtra(NAME_EXTRA));
    }

    private void findViews() {
        welcomeText = findViewById(R.id.main_welcome_txt);
    }
}