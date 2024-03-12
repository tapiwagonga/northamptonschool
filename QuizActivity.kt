package com.example.northamptonschool

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {
    private var currentQuestionIndex = 0
    private var score = 0

    data class Question(val questionText: String, val answers: List<String>, val correctAnswerIndex: Int)

    private val questions = listOf(
        Question("What is 2+2?", listOf("3", "4", "5"), 1),
        // Add more questions as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Assuming buttons and textViews will be linked from XML, hence no findViewById calls here

        // Start Quiz button action
        findViewById<Button>(R.id.startQuizButton).setOnClickListener {
            startQuiz()
        }

        // Answer buttons actions
        findViewById<Button>(R.id.answerButton1).setOnClickListener { checkAnswer(0) }
        findViewById<Button>(R.id.answerButton2).setOnClickListener { checkAnswer(1) }
        findViewById<Button>(R.id.answerButton3).setOnClickListener { checkAnswer(2) }

        // Back button to return to MainActivity
        findViewById<Button>(R.id.backButton).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Initially, the quiz UI is not visible until the quiz starts
        setQuizVisibility(View.GONE)
    }

    private fun startQuiz() {
        currentQuestionIndex = 0
        score = 0
        setQuizVisibility(View.VISIBLE)
        findViewById<Button>(R.id.startQuizButton).visibility = View.GONE
        loadQuestion()
    }

    private fun setQuizVisibility(visibility: Int) {
        findViewById<TextView>(R.id.questionText).visibility = visibility
        findViewById<Button>(R.id.answerButton1).visibility = visibility
        findViewById<Button>(R.id.answerButton2).visibility = visibility
        findViewById<Button>(R.id.answerButton3).visibility = visibility
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        findViewById<TextView>(R.id.questionText).text = question.questionText
        findViewById<Button>(R.id.answerButton1).text = question.answers[0]
        findViewById<Button>(R.id.answerButton2).text = question.answers[1]
        findViewById<Button>(R.id.answerButton3).text = question.answers[2]
    }

    private fun checkAnswer(answerIndex: Int) {
        val question = questions[currentQuestionIndex]
        if (answerIndex == question.correctAnswerIndex) {
            score++
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                finishQuiz()
            }
        } else {
            finishQuiz()
        }
    }

    private fun finishQuiz() {
        Toast.makeText(this, "Wrong answer. Your score: $score", Toast.LENGTH_LONG).show()
        setQuizVisibility(View.GONE)
        findViewById<Button>(R.id.startQuizButton).visibility = View.VISIBLE
    }
}
