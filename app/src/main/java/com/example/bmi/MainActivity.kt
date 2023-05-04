/**
 * Jakub Słomiński, S18552
 * BMI
 */

package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bmiCalculator = findViewById<View>(R.id.button_calc) as Button
        val allowedFood = findViewById<View>(R.id.button_allowed_food) as Button
        val recipe = findViewById<View>(R.id.button_recipe) as Button
        val button_quiz = findViewById<View>(R.id.button_quiz) as Button
        val button_graph = findViewById<View>(R.id.button_graph) as Button
        bmiCalculator.setOnClickListener { openBmiCalculator() }
        allowedFood.setOnClickListener { openAllowedFood() }
        recipe.setOnClickListener { openRecipe() }
        button_quiz.setOnClickListener { openQuiz() }
        button_graph.setOnClickListener { openGraph() }
    }

    fun openBmiCalculator() {
        val intent = Intent(this, BmiCalculator::class.java)
        startActivity(intent)
    }

    fun openAllowedFood() {
        val intent = Intent(this, AllowedFood::class.java)
        startActivity(intent)
    }

    fun openRecipe() {
        val intent = Intent(this, Recipe::class.java)
        startActivity(intent)
    }

    fun openQuiz() {
        val intent = Intent(this, Quiz::class.java)
        startActivity(intent)
    }

    fun openGraph() {
        val intent = Intent(this, Graph::class.java)
        startActivity(intent)
    }
}