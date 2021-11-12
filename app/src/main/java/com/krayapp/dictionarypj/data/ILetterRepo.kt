package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.retrofit2.letter.LetterInfo


interface ILetterRepo {
    fun getLetterInfo(letter:String, callback : retrofit2.Callback<List<LetterInfo>>)
}