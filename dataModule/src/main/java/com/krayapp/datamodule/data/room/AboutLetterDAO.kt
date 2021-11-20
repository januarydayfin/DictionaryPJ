package com.krayapp.datamodule.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.krayapp.datamodule.data.AboutLetter

@Dao
interface AboutLetterDAO {
    @Query("SELECT * FROM AboutLetter")
    fun getAll():List<AboutLetter>

    @Query("SELECT * FROM AboutLetter WHERE text LIKE :letter")
    fun getInfoByText(letter:String):AboutLetter

    @Insert
    fun insertLetter(letter: AboutLetter)

}
