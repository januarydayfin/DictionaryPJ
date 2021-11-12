package com.krayapp.dictionarypj.data.room

import com.krayapp.dictionarypj.data.AboutLetter

interface ILetterDataBase {
    fun getAll():List<AboutLetter>
    fun getInfoByText(letter: String): AboutLetter
    fun insertLetter(letter:AboutLetter)
}