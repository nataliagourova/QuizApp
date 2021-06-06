package com.example.quizapp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.CorrectAnswerTracker;
import com.example.quizapp.R;
import com.example.quizapp.data.model.YesNoQuestion;

public class YesNoQuestionRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView questionText;
    private Button trueButton;
    private Button falseButton;
    private YesNoQuestion question;
    private int position;
    private CorrectAnswerTracker correctAnswerTracker;

    public YesNoQuestionRecyclerViewHolder(
            View itemView,
            CorrectAnswerTracker correctAnswerTracker) {
        super(itemView);
        this.correctAnswerTracker = correctAnswerTracker;
        questionText = itemView.findViewById(R.id.question_item_text);
        trueButton = itemView.findViewById(R.id.question_item_true_button);
        falseButton = itemView.findViewById(R.id.question_item_false_button);
        trueButton.setOnClickListener(v -> checkIfTrue());
        falseButton.setOnClickListener(v -> checkIfFalse());
    }

    public void setQuestion(int position, YesNoQuestion question) {
        this.questionText.setText(question.getQuestionText());
        this.question = question;
        this.position = position;
    }

    private void checkIfTrue() {
        if (question.isTrue()) {
            reportCorrect();
        }

        reportIncorrect();
    }

    private void checkIfFalse() {
        if (question.isTrue()) {
            reportIncorrect();
        }

        reportCorrect();
    }

    private void reportCorrect() {
        correctAnswerTracker.onQuestionAnswered(position, true);
    }

    private void reportIncorrect() {
        correctAnswerTracker.onQuestionAnswered(position, false);
    }
}
