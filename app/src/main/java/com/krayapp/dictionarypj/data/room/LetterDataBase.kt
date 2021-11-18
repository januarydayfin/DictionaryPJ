package com.krayapp.dictionarypj.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krayapp.dictionarypj.data.AboutLetter


@Database(
    exportSchema = false,
    entities = [AboutLetter::class],
    version = 1
)
abstract class LetterDataBase : RoomDatabase() {
    abstract fun letterDao(): AboutLetterDAO
}