package com.krayapp.datamodule.data.retrofit2.image

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ImageRemoteAccess {
    @Headers("Authorization: 563492ad6f917000010000010ba783552c754973b3f61180b87dee52")
    @GET("search")
    fun getImageFromApi(
        @Query("query") imageByLetter:String
    ):retrofit2.Call<ImageDTO>
}