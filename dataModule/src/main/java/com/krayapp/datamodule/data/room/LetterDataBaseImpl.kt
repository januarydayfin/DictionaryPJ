package com.krayapp.datamodule.data.room

import com.krayapp.datamodule.data.AboutLetter

class LetterDataBaseImpl(
    private val db:LetterDataBase
) :ILetterDataBase {
    override fun getAll():List<AboutLetter> =
        db.letterDao().getAll()

    override fun getInfoByText(letter: String): AboutLetter =
        db.letterDao().getInfoByText(letter)

    override fun insertLetter(letter:AboutLetter) = db.letterDao().insertLetter(letter)
}