package com.example.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AllowedFood extends AppCompatActivity {

    private double weight = 0.0;
    private double height = 0.0;
    private int age = 0;

    private TextView heightTextView;
    private TextView weightTextView;
    private TextView ageTextView;
    private TextView totalTextView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allowed_food);


        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));


        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText ageEditText =
                (EditText) findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);


    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString()) / 100;
                weightTextView.setText(String.format(weight + ""));

            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;

            }
            clickedCalculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
            clickedCalculate();
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString()) / 100.0;
                heightTextView.setText(String.format(height + ""));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
            clickedCalculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
            clickedCalculate();
        }
    };
    private final TextWatcher ageEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                age = (int) (Integer.parseInt(s.toString()));
                ageTextView.setText(String.format(age + ""));
            } catch (NumberFormatException e) {
                age = 0;
            }

            clickedCalculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
            clickedCalculate();
        }
    };


    public void clickedCalculate() {

        double total = (88.362 + (13.397 * weight) + (4.799 * height)) - (5.677 * age);
        totalTextView.setText(String.format(total + ""));
    }


}
