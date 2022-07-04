package com.umer.reminder.feature_note.data.repository

import com.umer.reminder.feature_note.data.data_source.ReminderDao
import com.umer.reminder.feature_note.domain.model.Note
import com.umer.reminder.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(
    private val reminderDao: ReminderDao
) : NoteRepository{

    override fun getNotes(): Flow<List<Note>> {
        return reminderDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return reminderDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        reminderDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        reminderDao.deleteNote(note)
    }

}