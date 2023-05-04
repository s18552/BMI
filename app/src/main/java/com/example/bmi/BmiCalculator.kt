/**
 * Jakub Słomiński, S18552
 * Kalkulator BMI
 */
package com.example.bmi

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiCalculator : AppCompatActivity() {
    //dodanie wagi oraz wzrostu i inicjalizacja defaultowych wartosci
    private var weight = 0.0
    private var height = 0.0
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var bmiTextView: TextView? = null

    //przypisanie widoków na podstawie id z activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_calc)
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        bmiTextView = findViewById<View>(R.id.bmiTextView) as TextView
        bmiTextView!!.text = 0.0.toString()

        //dodanie listenerów do pól z inputem textu
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
    }

    //obliczanie BMI
    private fun calculate() {
        val bmi = weight / (height * height)
        if (bmi >= 25 || bmi < 18.5) bmiTextView!!.setBackgroundColor(Color.parseColor("RED")) else bmiTextView!!.setBackgroundColor(
            Color.parseColor("GREEN")
        )
        bmiTextView!!.text = bmi.toString()
    }

    //konfiguracja listenera dla wagi
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                weight = s.toString().toDouble() / 100.0
                weightTextView!!.text = weight.toString()
            } catch (e: NumberFormatException) {
                weight = 0.0
            }
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }

    //konfiguracja listenera dla wzrostu
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = height.toString()
            } catch (e: NumberFormatException) {
                height = 0.0
            }
        }

        override fun afterTextChanged(s: Editable) {
            //obliczanie BMI dopiero po aktualizacji pola ze wzrostem
            calculate()
        }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
}