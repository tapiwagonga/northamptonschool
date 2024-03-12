package com.example.northamptonschool

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        // Define EditTexts for input numbers
        val firstNumberEditText = findViewById<EditText>(R.id.edittext_first_number)
        val secondNumberEditText = findViewById<EditText>(R.id.edittext_second_number)

        // Define TextView for displaying the result
        val resultTextView = findViewById<TextView>(R.id.textview_result)

        // Define Buttons for each operation
        val addButton = findViewById<Button>(R.id.button_add)
        val subtractButton = findViewById<Button>(R.id.button_subtract)
        val multiplyButton = findViewById<Button>(R.id.button_multiply)
        val divideButton = findViewById<Button>(R.id.button_divide)
        val modulusButton = findViewById<Button>(R.id.button_modulus)

        // Set onClickListeners for each operation button
        addButton.setOnClickListener {
            calculateResult(firstNumberEditText, secondNumberEditText, resultTextView, "add")
        }

        subtractButton.setOnClickListener {
            calculateResult(firstNumberEditText, secondNumberEditText, resultTextView, "subtract")
        }

        multiplyButton.setOnClickListener {
            calculateResult(firstNumberEditText, secondNumberEditText, resultTextView, "multiply")
        }

        divideButton.setOnClickListener {
            calculateResult(firstNumberEditText, secondNumberEditText, resultTextView, "divide")
        }

        modulusButton.setOnClickListener {
            calculateResult(firstNumberEditText, secondNumberEditText, resultTextView, "modulus")
        }
    }

    private fun calculateResult(firstNumEditText: EditText, secondNumEditText: EditText, resultTextView: TextView, operation: String) {
        val firstNum = firstNumEditText.text.toString().trim().toDoubleOrNull()
        val secondNum = secondNumEditText.text.toString().trim().toDoubleOrNull()

        if (firstNum == null || secondNum == null) {
            resultTextView.text = getString(R.string.invalid_input)
            return
        }

        val result = when (operation) {
            "add" -> firstNum + secondNum
            "subtract" -> firstNum - secondNum
            "multiply" -> firstNum * secondNum
            "divide" -> if (secondNum != 0.0) firstNum / secondNum else null
            "modulus" -> if (secondNum != 0.0) firstNum % secondNum else null
            else -> null
        }

        resultTextView.text = if (result != null) getString(R.string.result_text, result.toString()) else getString(R.string.error_message)
    }
}
