/**
 * Jakub Słomiński, S18552
 * Kalkulator BMI
 * */


package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText;
import android.widget.TextView; // for displaying text


public class MainActivity extends AppCompatActivity {

    //dodanie wagi oraz wzrostu i inicjalizacja defaultowych wartosci
    private double weight = 0.0;
    private double height = 0.0;
    private TextView heightTextView;
    private TextView weightTextView;
    private TextView bmiTextView;


    //przypisanie widoków na podstawie id z activity_main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        bmiTextView = (TextView) findViewById(R.id.bmiTextView);
        bmiTextView.setText(Double.toString(0.0));

        //dodanie listenerów do pól z inputem textu
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);
    }

    //obliczanie BMI
    private void calculate() {
        double bmi = weight / (height * height);
        if(bmi>=25 || bmi<18.5) bmiTextView.setBackgroundColor(Color.parseColor("RED"));
        else bmiTextView.setBackgroundColor(Color.parseColor("GREEN"));
        bmiTextView.setText(Double.toString(bmi));
    }

    //konfiguracja listenera dla wagi
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {
            try {
                weight = Double.parseDouble(s.toString()) / 100.0;
                weightTextView.setText(Double.toString(weight));
            } catch (NumberFormatException e) {
                weight = 0.0;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };

    //konfiguracja listenera dla wzrostu
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(Double.toString(height));
            } catch (NumberFormatException e) {
                height = 0.0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            //obliczanie BMI dopiero po aktualizacji pola ze wzrostem
            calculate();
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}


