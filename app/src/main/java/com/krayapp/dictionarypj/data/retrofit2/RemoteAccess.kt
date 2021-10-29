package com.krayapp.dictionarypj.data.retrofit2

import com.krayapp.dictionarypj.data.LetterInfo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteAccess {
    @GET("words/search?search={letter}")
    fun getLetterInfo(
        @Path ("letter")letter:String
    ):Observable<LetterInfo>
}