package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.LetterInfo
import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import io.reactivex.Observable
import javax.inject.Inject

class LetterRepoImpl(
    private val api:RemoteAccess
):ILetterRepo {
    override fun getLetterInfo(letter: String): Observable<List<LetterInfo>> =
       api.getLetterInfo(letter)
}