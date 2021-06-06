package com.example.quizapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.data.model.YesNoQuestion;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecyclerViewAdapter extends RecyclerView.Adapter<YesNoQuestionRecyclerViewHolder> {

    private List<YesNoQuestion> questions;

    public QuestionsRecyclerViewAdapter() {
        questions = new ArrayList<>();
    }

    public void setQuestions(List<YesNoQuestion> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public YesNoQuestionRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View questionItemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.yes_no_question_recycler_item, parent, false);
        return new YesNoQuestionRecyclerViewHolder(questionItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull YesNoQuestionRecyclerViewHolder holder, int position) {
        holder.setQuestion(questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
