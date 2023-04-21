package com.example.bmi;

public class ModelQuiz {
    private final int question;
    private final boolean answer;

    public ModelQuiz(int mQuestion, boolean mAnswer) {
        this.question = mQuestion;
        this.answer = mAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

}

