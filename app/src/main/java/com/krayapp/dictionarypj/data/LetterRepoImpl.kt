package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import io.reactivex.Observable
import retrofit2.Callback

class LetterRepoImpl(
    private val api:RemoteAccess
):ILetterRepo {
    override fun getLetterInfo(letter: String, callback: Callback<List<LetterInfo>>) {
       return api.getLetterInfo(letter).enqueue(callback)
    }
}