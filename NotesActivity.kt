package com.example.northamptonschool

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotesActivity : AppCompatActivity() {

    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val recyclerView = findViewById<RecyclerView>(R.id.notesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notesAdapter = NotesAdapter(listOf(), this::onNoteClick)
        recyclerView.adapter = notesAdapter

        findViewById<FloatingActionButton>(R.id.addNoteFab).setOnClickListener {
            // Handle creation of a new note
            showNoteDetail(null)
        }

        loadNotes()
    }

    private fun loadNotes() {
        // Load notes from file storage and update the RecyclerView adapter
    }

    private fun onNoteClick(note: Note) {
        // Handle click on note item to view or edit
        showNoteDetail(note)
    }

    private fun showNoteDetail(note: Note?) {
        // Show NoteDetailFragment for viewing or editing a note
    }
}
