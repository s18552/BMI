package com.example.bmi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Quiz extends AppCompatActivity {

    private TextView txtQuestion;
    private int questionIndex;
    private int quizQuestion;
    private TextView quizStatsTextView;
    private int userScore;


    private final ModelQuiz[] questionCollection = new ModelQuiz[]{
            new ModelQuiz(R.string.p1, false),
            new ModelQuiz(R.string.p2, false),
            new ModelQuiz(R.string.p3, false),
            new ModelQuiz(R.string.p4, false),
            new ModelQuiz(R.string.p5, false),
            new ModelQuiz(R.string.p6, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestion.setText(questionCollection[questionIndex].getQuestion());
        quizStatsTextView = findViewById(R.id.txtQuizStats);


        Button buttonTrue = findViewById(R.id.button_true);
        buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateUserAnswer(true);
                changeQuestionOnButtonClick();
            }
        });

        Button buttonFalse = findViewById(R.id.button_false);
        buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateUserAnswer(false);
                changeQuestionOnButtonClick();

            }
        });

    }

    private void changeQuestionOnButtonClick() {
        questionIndex = (questionIndex + 1) % 6;
        if (questionIndex == 0) {
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("Koniec Quizu");
            quizAlert.setMessage("Twój wynik: " + userScore);
            quizAlert.setPositiveButton("Zakończ Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            quizAlert.show();
        }
        quizQuestion = questionCollection[questionIndex].getQuestion();
        txtQuestion.setText(quizQuestion);
        quizStatsTextView.setText(String.format("%d/6", userScore));
    }

    private void evaluateUserAnswer(boolean userGuess) {
        boolean currentQuestionAnswer = questionCollection[questionIndex].isAnswer();
        if (currentQuestionAnswer == userGuess) userScore = userScore + 1;
    }

}
