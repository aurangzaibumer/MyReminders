package com.umer.reminder.di

import android.app.Application
import androidx.room.Room
import com.umer.reminder.feature_note.data.data_source.ReminderDatabase
import com.umer.reminder.feature_note.data.repository.NoteRepositoryImp
import com.umer.reminder.feature_note.domain.repository.NoteRepository
import com.umer.reminder.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {
    @Provides
    @Singleton
    fun provideNoteDataBase(application: Application):ReminderDatabase{
        return Room.inMemoryDatabaseBuilder(application,ReminderDatabase::class.java)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(reminderDatabase: ReminderDatabase):NoteRepository{
        return NoteRepositoryImp(reminderDatabase.reminderDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(noteRepository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNotes = DeleteNotes(noteRepository),
            addNote = AddNotes(noteRepository),
            getNote = GetNote(noteRepository)
        )
    }
}