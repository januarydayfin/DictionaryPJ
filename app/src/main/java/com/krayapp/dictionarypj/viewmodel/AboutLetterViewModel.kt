package com.krayapp.dictionarypj.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.data.LetterInfo
import com.krayapp.dictionarypj.data.room.ILetterDataBase
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutLetterViewModel(
    private val repo: ILetterRepo,
    private val database: ILetterDataBase
) : ViewModel() {
    private val dataScope = CoroutineScope(Dispatchers.IO)
    private var baseJob: Job? = null

    private val _mutableLiveData = MutableLiveData<List<AboutLetter>>()
    val mutableLiveData: LiveData<List<AboutLetter>>
        get() = _mutableLiveData

    fun getData(letter: String) {
        dataScope.launch {
            repo.getLetterInfo(letter, callback)
        }
    }

    private val callback = object : Callback<List<LetterInfo>> {
        override fun onResponse(
            call: Call<List<LetterInfo>>,
            response: Response<List<LetterInfo>>
        ) {
            val simpleList = convertToSimple(response.body()!!)
            _mutableLiveData.postValue(simpleList)
        }

        override fun onFailure(call: Call<List<LetterInfo>>, t: Throwable) {
            println(t)
        }

    }


    fun insertToDataBase(letter: AboutLetter) {
        baseJob?.cancel()
        baseJob =
            CoroutineScope(Dispatchers.IO)
                .launch {
                    if (isActive)
                        database.insertLetter(letter)
                }
    }

    private fun convertToSimple(letterInfo: List<LetterInfo>): List<AboutLetter> {
        val newList = mutableListOf<AboutLetter>()
        letterInfo.forEach {
            newList.add(AboutLetter(it.text!!, it.meanings?.get(0)?.translation?.text!!))
        }
        return newList
    }

    override fun onCleared() {
        super.onCleared()
        baseJob?.cancel()
    }
}