package com.umer.reminder.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.umer.reminder.feature_note.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class ReminderDatabase : RoomDatabase() {
    abstract val reminderDao:ReminderDao

    companion object{
        const val DATABASE_NAME = "reminder_db"
    }
}