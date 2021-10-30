package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.LetterInfo
import io.reactivex.Observable


interface ILetterRepo {
    fun getLetterInfo(letter:String):Observable<List<LetterInfo>>
}