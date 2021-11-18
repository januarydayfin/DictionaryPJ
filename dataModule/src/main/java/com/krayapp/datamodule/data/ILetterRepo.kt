package com.krayapp.datamodule.data

import com.krayapp.datamodule.data.retrofit2.letter.LetterInfo


interface ILetterRepo {
    fun getLetterInfo(letter:String, callback : retrofit2.Callback<List<LetterInfo>>)
}