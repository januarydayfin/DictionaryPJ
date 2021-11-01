package com.krayapp.dictionarypj.data.retrofit2

import com.krayapp.dictionarypj.data.LetterInfo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteAccess {
    @GET("words/search")
    fun getLetterInfo(
        @Query ("search")search:String
    ):Observable<List<LetterInfo>>
}