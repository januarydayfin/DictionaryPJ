package com.krayapp.dictionarypj.presenter

import com.krayapp.dictionarypj.MySchedulers
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.data.LetterInfo
import com.krayapp.dictionarypj.view.IMainFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainFragmentPresenter(
    private val view: IMainFragment,
    private val repo: ILetterRepo
) : IMainPresenter {
    private var disposables = CompositeDisposable()

    private val schedulers = MySchedulers()
    override fun loadLetterInfo(letter: String) {
        repo.getLetterInfo(letter)
            .map(::convertToSimple)
            .observeOn(schedulers.main())
            .doOnNext(view::showLetterInfo)
            .doOnError{error -> println("Retrofit Error $error")}
            .subscribeOn(schedulers.io())
            .subscribe()
            .addTo(disposables)
    }



    override fun onStop() {
        disposables.dispose()
    }

    private fun convertToSimple(letterInfo: List<LetterInfo>): List<AboutLetter> {
        val newList = mutableListOf<AboutLetter>()
        letterInfo.forEach {
            newList.add(AboutLetter(it.text!!, it.meanings?.get(0)?.translation?.text!!))
        }
        return newList
    }

}