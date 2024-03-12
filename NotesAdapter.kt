package com.example.northamptonschool

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val notes: List<Note>, private val onClick: (Note) -> Unit) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(view: View, val onClick: (Note) -> Unit) : RecyclerView.ViewHolder(view) {
        private val noteTextView = view.findViewById<TextView>(R.id.noteText)
        private var currentNote: Note? = null

        init {
            view.setOnClickListener {
                currentNote?.let {
                    onClick(it)
                }
            }
        }

        fun bind(note: Note) {
            currentNote = note
            noteTextView.text = note.title // Assuming Note has a 'text' property
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note)
    }

    override fun getItemCount() = notes.size
}
