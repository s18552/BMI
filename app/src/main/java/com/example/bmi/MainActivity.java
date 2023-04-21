package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bmiCalculator = (Button) findViewById(R.id.button_calc);
        Button allowedFood = (Button) findViewById(R.id.button_allowed_food);
        Button recipe = (Button) findViewById(R.id.button_recipe);

        Button button_quiz = (Button) findViewById(R.id.button_quiz);
        Button button_graph = (Button) findViewById(R.id.button_graph);

        bmiCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiCalculator();
            }
        });

        allowedFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAllowedFood();
            }
        });
        recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipe();
            }
        });
        button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
        button_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGraph();
            }
        });
    }

    public void openBmiCalculator() {
        Intent intent = new Intent(this, BmiCalculator.class);
        startActivity(intent);
    }
    public void openAllowedFood() {
        Intent intent = new Intent(this, AllowedFood.class);
        startActivity(intent);
    }
    public void openRecipe() {
        Intent intent = new Intent(this, Recipe.class);
        startActivity(intent);
    }

    public void openQuiz() {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }
    public void openGraph() {
        Intent intent = new Intent(this, Graph.class);
        startActivity(intent);
    }
}
