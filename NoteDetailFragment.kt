package com.example.northamptonschool

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class NoteDetailFragment : Fragment() {

    private var noteId: String? = null // Use this if you have unique IDs for notes

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val saveButton = view.findViewById<FloatingActionButton>(R.id.saveNoteFab)
        val noteContentEditText = view.findViewById<TextInputEditText>(R.id.noteContentEditText)

        noteId = arguments?.getString("noteId")
        // If noteId is not null, load the note content into noteContentEditText

        saveButton.setOnClickListener {
            // Save the note content to file storage here
            // After saving, you can navigate back to the previous Fragment or Activity

            // Using FragmentManager to pop the back stack
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}
