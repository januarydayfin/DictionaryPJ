package com.krayapp.dictionarypj.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.dictionarypj.data.IImageLoader
import com.krayapp.dictionarypj.data.retrofit2.image.ImageDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InLetterViewModel(private val api: IImageLoader) : ViewModel() {

    private val _mutableLiveData = MutableLiveData<ImageDTO>()
    val mutableLiveData: LiveData<ImageDTO>
        get() = _mutableLiveData

    fun getImage(letter: String) {
        api.getImageFromApi(letter, callback)
    }

    private val callback = object : Callback<ImageDTO> {
        override fun onResponse(call: Call<ImageDTO>, response: Response<ImageDTO>) {
            _mutableLiveData.postValue(response.body())
        }

        override fun onFailure(call: Call<ImageDTO>, t: Throwable) {
            println("VVV $t")
        }

    }
}