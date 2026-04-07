package com.example.myfirstkmpapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myfirstkmpapp.data.Note
import com.example.myfirstkmpapp.data.dummyNotes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotesViewModel : ViewModel() {
    private val _notes = MutableStateFlow(dummyNotes)
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    // Fungsi untuk mengubah status favorite reaktif
    fun toggleFavorite(noteId: Int) {
        _notes.update { currentNotes ->
            currentNotes.map { note ->
                if (note.id == noteId) {
                    note.copy(isFavorite = !note.isFavorite)
                } else {
                    note
                }
            }
        }
    }
}