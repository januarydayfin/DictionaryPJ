package com.krayapp.datamodule.data.room

import com.krayapp.datamodule.data.AboutLetter

interface ILetterDataBase {
    fun getAll():List<AboutLetter>
    fun getInfoByText(letter: String): AboutLetter
    fun insertLetter(letter:AboutLetter)
}