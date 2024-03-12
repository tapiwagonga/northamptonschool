package com.example.northamptonschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Notes Activity
        findViewById<Button>(R.id.startNotesActivityBtn).setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }

        // Folders Activity
        findViewById<Button>(R.id.manageFoldersButton).setOnClickListener {
            startActivity(Intent(this, FolderActivity::class.java))
        }

        // Quiz Activity
        findViewById<Button>(R.id.startQuizActivityBtn).setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }

        // Calculator Activity
        findViewById<Button>(R.id.CalculatorBtn).setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}
