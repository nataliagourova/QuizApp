package com.example.quizapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.CorrectAnswerTracker;
import com.example.quizapp.CorrectCountTracker;
import com.example.quizapp.R;
import com.example.quizapp.data.model.YesNoQuestion;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionsRecyclerViewAdapter extends RecyclerView.Adapter<YesNoQuestionRecyclerViewHolder>
        implements CorrectAnswerTracker {

    private List<YesNoQuestion> questions;
    private List<Boolean> correctQuestions;
    private CorrectCountTracker correctCountTracker;

    public QuestionsRecyclerViewAdapter(CorrectCountTracker correctCountTracker) {
        this.correctCountTracker = correctCountTracker;
        questions = new ArrayList<>();
        correctQuestions = new ArrayList<>();
    }

    public void setQuestions(List<YesNoQuestion> questions) {
        this.questions = questions;
        this.correctQuestions = new ArrayList<>(Arrays.asList(new Boolean[questions.size()]));
        correctCountTracker.onCorrectCountChanged(0, questions.size());
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public YesNoQuestionRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View questionItemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.yes_no_question_recycler_item, parent, false);
        return new YesNoQuestionRecyclerViewHolder(questionItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull YesNoQuestionRecyclerViewHolder holder, int position) {
        holder.setQuestion(position, questions.get(position));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    @Override
    public void onQuestionAnswered(int position, boolean isCorrect) {
        correctQuestions.set(position, isCorrect);
        long correctCount = correctQuestions
                .stream()
                .filter(q -> q != null && q)
                .count();
        correctCountTracker.onCorrectCountChanged((int) correctCount, questions.size());
    }
}
