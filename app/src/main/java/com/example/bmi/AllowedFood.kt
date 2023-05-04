package com.example.bmi

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AllowedFood : AppCompatActivity() {
    private var weight = 0.0
    private var height = 0.0
    private var age = 0
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var ageTextView: TextView? = null
    private var totalTextView: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.allowed_food)
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        ageTextView = findViewById<View>(R.id.ageTextView) as TextView
        totalTextView = findViewById<View>(R.id.totalTextView) as TextView
        totalTextView!!.text = String.format(0.toString() + "")
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
        val ageEditText = findViewById<View>(R.id.ageEditText) as EditText
        ageEditText.addTextChangedListener(ageEditTextWatcher)
    }

    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                weight = s.toString().toDouble() / 100
                weightTextView!!.text = String.format(weight.toString() + "")
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                weight = 0.0
            }
            clickedCalculate()
        }

        override fun afterTextChanged(s: Editable) {
            clickedCalculate()
        }

        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = String.format(height.toString() + "")
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                height = 0.0
            }
            clickedCalculate()
        }

        override fun afterTextChanged(s: Editable) {
            clickedCalculate()
        }
    }
    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                age = s.toString().toInt()
                ageTextView!!.text = String.format(age.toString() + "")
            } catch (e: NumberFormatException) {
                age = 0
            }
            clickedCalculate()
        }

        override fun afterTextChanged(s: Editable) {
            clickedCalculate()
        }
    }

    fun clickedCalculate() {
        val total = 88.362 + 13.397 * weight + 4.799 * height - 5.677 * age
        totalTextView!!.text = String.format(total.toString() + "")
    }
}