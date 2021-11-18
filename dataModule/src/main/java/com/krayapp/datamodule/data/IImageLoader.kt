package com.krayapp.datamodule.data

import com.krayapp.datamodule.data.retrofit2.image.ImageDTO
import retrofit2.Callback

interface IImageLoader {
    fun getImageFromApi(letter:String, callback:Callback<ImageDTO>)
}