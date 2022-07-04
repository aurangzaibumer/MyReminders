package com.umer.reminder.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umer.reminder.ui.theme.BabyBlue
import com.umer.reminder.ui.theme.RedOrange
import com.umer.reminder.ui.theme.RedPink
import com.umer.reminder.ui.theme.Violet
import java.lang.Exception


@Entity
data class Note(
    val title:String,
    val content:String,
    val timesStamp:String,
    val color:Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange,LightGray, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message:String):Exception(message)