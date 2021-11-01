package com.krayapp.dictionarypj.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krayapp.dictionarypj.ISchedulers
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.data.LetterInfo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainFragmentViewModel
    : ViewModel(), IMainViewModel {
    private lateinit var repo: ILetterRepo
    private lateinit var schedulers: ISchedulers

    private var disposables = CompositeDisposable()

    private val _mutableLiveData = MutableLiveData<List<AboutLetter>>()
    val mutableLiveData: LiveData<List<AboutLetter>>
        get() = _mutableLiveData

    fun getData(letter: String) {
        repo.getLetterInfo(letter)
            .map(::convertToSimple)
            .observeOn(schedulers.main())
            .doOnNext(_mutableLiveData::postValue)
            .doOnError { error -> println("Retrofit Error $error") }
            .subscribeOn(schedulers.io())
            .subscribe()
            .addTo(disposables)

    }

    fun setRepos(repo: ILetterRepo, schedulers: ISchedulers) {
        this.repo = repo
        this.schedulers = schedulers
    }

    private fun convertToSimple(letterInfo: List<LetterInfo>): List<AboutLetter> {
        val newList = mutableListOf<AboutLetter>()
        letterInfo.forEach {
            newList.add(AboutLetter(it.text!!, it.meanings?.get(0)?.translation?.text!!))
        }
        return newList
    }


}