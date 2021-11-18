package com.krayapp.datamodule.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.krayapp.datamodule.data.AboutLetter


@Database(
    exportSchema = false,
    entities = [AboutLetter::class],
    version = 1
)
abstract class LetterDataBase : RoomDatabase() {
    abstract fun letterDao(): AboutLetterDAO
}