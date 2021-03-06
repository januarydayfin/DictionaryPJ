package com.krayapp.datamodule.data

import com.krayapp.datamodule.data.retrofit2.letter.LetterInfo
import com.krayapp.datamodule.data.retrofit2.letter.RemoteAccess
import retrofit2.Callback

class LetterRepoImpl(
    private val api: RemoteAccess
):ILetterRepo {

    override fun getLetterInfo(letter: String, callback: Callback<List<LetterInfo>>) {
       return api.getLetterInfo(letter).enqueue(callback)
    }
}