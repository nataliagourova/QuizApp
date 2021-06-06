package com.example.quizapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.data.model.YesNoQuestion;

import org.jetbrains.annotations.NotNull;

public class YesNoQuestionRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private YesNoQuestion question;

    public YesNoQuestionRecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        questionText = itemView.findViewById(R.id.question_item_text);
        trueButton = itemView.findViewById(R.id.question_item_true_button);
        falseButton = itemView.findViewById(R.id.question_item_false_button);
        trueButton.setOnClickListener(v -> checkIfTrue());
        falseButton.setOnClickListener(v -> checkIfFalse());
    }

    public void setQuestion(YesNoQuestion question) {
        this.questionText.setText(question.getQuestionText());
        this.question = question;
    }

    private void checkIfTrue() {
        if (question.isTrue()) {
            showCorrectToast();
        }

        showIncorrectToast();
    }

    private void checkIfFalse() {
        if (question.isTrue()) {
            showIncorrectToast();
        }

        showCorrectToast();
    }

    private void showCorrectToast() {
        Toast.makeText(trueButton.getContext(), "Correct!", Toast.LENGTH_SHORT).show();
    }

    private void showIncorrectToast() {
        Toast.makeText(trueButton.getContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
    }
}
