package com.krayapp.dictionarypj.data.room

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.krayapp.dictionarypj.data.AboutLetter

@Dao
interface AboutLetterDAO {
    @Query("SELECT * FROM AboutLetter")
    fun getAll():List<AboutLetter>

    @Query("SELECT * FROM AboutLetter WHERE text LIKE :letter")
    fun getInfoByText(letter:String):AboutLetter

    @Insert
    fun insertLetter(letter: AboutLetter)

    @Query("SELECT text from AboutLetter")
    fun getLetterList(): List<LetterTextOnly>
}

data class LetterTextOnly(
    @ColumnInfo(name = "text")val text: String
)