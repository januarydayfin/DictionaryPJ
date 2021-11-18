package com.krayapp.dictionarypj.data.retrofit2.image


import com.google.gson.annotations.Expose

data class ImageDTO(
    @Expose
    val photos: List<ImageSource>
)
data class ImageSource(
    @Expose
    val src:ImageSizeUrl
)
data class ImageSizeUrl(
    @Expose
    val medium:String,
    @Expose
    val original :String,
    @Expose
    val large:String
)
