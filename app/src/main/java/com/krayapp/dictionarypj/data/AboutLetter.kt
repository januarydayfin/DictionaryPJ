package com.krayapp.dictionarypj.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AboutLetter(
    val text: String,
    val translation: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)