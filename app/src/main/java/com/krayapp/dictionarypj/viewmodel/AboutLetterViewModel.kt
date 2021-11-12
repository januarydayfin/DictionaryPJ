package com.krayapp.dictionarypj.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.data.LetterInfo
import com.krayapp.dictionarypj.data.room.LetterDataBase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutLetterViewModel(
    private val repo: ILetterRepo,
    private val database:LetterDataBase
    ) : ViewModel() {
    private var disposables = CompositeDisposable()
    private val dataScope = CoroutineScope(Dispatchers.IO)

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


    private fun convertToSimple(letterInfo: List<LetterInfo>): List<AboutLetter> {
        val newList = mutableListOf<AboutLetter>()
        letterInfo.forEach {
            newList.add(AboutLetter(it.text!!, it.meanings?.get(0)?.translation?.text!!))
        }
        return newList
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}