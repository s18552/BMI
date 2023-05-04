package com.example.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Quiz : AppCompatActivity() {
    private var txtQuestion: TextView? = null
    private var questionIndex = 0
    private var quizQuestion = 0
    private var quizStatsTextView: TextView? = null
    private var userScore = 0
    private val questionCollection = arrayOf(
        ModelQuiz(R.string.p1, false),
        ModelQuiz(R.string.p2, false),
        ModelQuiz(R.string.p3, false),
        ModelQuiz(R.string.p4, false),
        ModelQuiz(R.string.p5, false),
        ModelQuiz(R.string.p6, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        txtQuestion = findViewById(R.id.txtQuestion)
        txtQuestion!!.setText(questionCollection[questionIndex].question)
        quizStatsTextView = findViewById(R.id.txtQuizStats)
        val buttonTrue = findViewById<Button>(R.id.button_true)
        buttonTrue.setOnClickListener {
            evaluateUserAnswer(true)
            changeQuestionOnButtonClick()
        }
        val buttonFalse = findViewById<Button>(R.id.button_false)
        buttonFalse.setOnClickListener {
            evaluateUserAnswer(false)
            changeQuestionOnButtonClick()
        }
    }

    private fun changeQuestionOnButtonClick() {
        questionIndex = (questionIndex + 1) % 6
        if (questionIndex == 0) {
            val quizAlert = AlertDialog.Builder(this)
            quizAlert.setCancelable(false)
            quizAlert.setTitle("Koniec Quizu")
            quizAlert.setMessage("Twój wynik: $userScore")
            quizAlert.setPositiveButton("Zakończ Quiz") { dialogInterface, i -> finish() }
            quizAlert.show()
        }
        quizQuestion = questionCollection[questionIndex].question
        txtQuestion!!.setText(quizQuestion)
        quizStatsTextView!!.text = String.format("%d/6", userScore)
    }

    private fun evaluateUserAnswer(userGuess: Boolean) {
        val currentQuestionAnswer = questionCollection[questionIndex].isAnswer
        if (currentQuestionAnswer == userGuess) userScore = userScore + 1
    }
}