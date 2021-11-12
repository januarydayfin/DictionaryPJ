package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.retrofit2.image.ImageDTO
import retrofit2.Callback

interface IImageLoader {
    fun getImageFromApi(letter:String, callback:Callback<ImageDTO>)
}