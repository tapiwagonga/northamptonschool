package com.example.northamptonschool

import android.content.Context
import java.io.File

class FileStorage(private val context: Context) {

    fun saveNote(note: Note) {
        context.openFileOutput(note.id, Context.MODE_PRIVATE).use { output ->
            output.write(note.toString().toByteArray())
        }
    }

    fun readNotes(): List<Note> {
        val notes = mutableListOf<Note>()
        context.filesDir.listFiles()?.forEach { file ->
            val content = file.readText()
            val note = parseNoteFromString(content)
            if (note != null) {
                notes.add(note)
            }
        }
        return notes
    }

    fun deleteNote(noteId: String) {
        context.deleteFile(noteId)
    }

    private fun parseNoteFromString(content: String): Note? {
        // Assuming a simple serialization format: id,title,content,category
        // You should implement proper error handling and format checking
        val parts = content.split(",")
        return if (parts.size == 4) Note(parts[0], parts[1], parts[2], parts[3]) else null
    }

    private fun Note.toString(): String {
        // Convert a Note object to a String
        return "${this.id},${this.title},${this.content},${this.category}"
    }
}
