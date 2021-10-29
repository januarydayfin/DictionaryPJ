package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.LetterInfo
import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import io.reactivex.Observable

class LetterRepoImpl(
    private val api:RemoteAccess
):ILetterRepo {
    override fun getLetterInfo(letter: String): Observable<LetterInfo> =
       api.getLetterInfo(letter)
}