package com.krayapp.dictionarypj.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.krayapp.datamodule.data.AboutLetter
import com.krayapp.datamodule.data.ILetterRepo
import com.krayapp.datamodule.data.retrofit2.letter.LetterInfo
import com.krayapp.datamodule.data.room.ILetterDataBase
import com.krayapp.dictionarypj.view.Screens.InLetterScreen
import kotlinx.coroutines.*
import org.koin.core.qualifier.named
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin


class AboutLetterViewModel(
    private val router: Router
) : ViewModel() {
    private val dataScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var baseJob: Job? = null

    private val scope:Scope by lazy{getKoin().createScope("", named("viewModelDataScope"))}
    private val repo: ILetterRepo = scope.get<ILetterRepo>()
    private val database: ILetterDataBase = scope.get<ILetterDataBase>()

    private val _mutableLiveData = MutableLiveData<List<AboutLetter>>()
    val mutableLiveData: LiveData<List<AboutLetter>>
        get() = _mutableLiveData


    fun getData(letter: String) {
        baseJob?.cancel()
        baseJob = dataScope.launch {
            repo.getLetterInfo(letter, callback)
        }
    }

    fun findLetterInLocalBase(letter: String) {
        baseJob?.cancel()
        baseJob = dataScope.launch {
            val localText: AboutLetter? = database.getInfoByText(letter)
            if (localText != null) {
                _mutableLiveData.postValue(listOf(localText))
            } else {
                _mutableLiveData.postValue(
                    listOf(
                        AboutLetter(
                            "Letter not found in base",
                            "Слово отсутствует в базе"
                        )
                    )
                )
            }
        }

    }

    private val callback = object : Callback<List<LetterInfo>> {
        override fun onResponse(
            call: Call<List<LetterInfo>>,
            response: Response<List<LetterInfo>>
        ) {
            val simpleList = convertToSimple(response.body()!!)
            _mutableLiveData.postValue(simpleList)
            insertToDataBase(simpleList.first())
        }

        override fun onFailure(call: Call<List<LetterInfo>>, t: Throwable) {
            println(t)
        }
    }

    fun openInLetter(aboutLetter: AboutLetter) {
        router.navigateTo(InLetterScreen(aboutLetter))
    }

    private fun insertToDataBase(letter: AboutLetter) {
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