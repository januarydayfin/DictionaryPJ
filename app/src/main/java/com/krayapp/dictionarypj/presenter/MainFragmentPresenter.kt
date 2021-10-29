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
    private val list = mutableListOf<AboutLetter>()
    override fun loadLetterInfo(letter: String) {
        repo.getLetterInfo(letter)
            .map(::convertToSimple)
            .doOnNext { info -> list.add(info) }
            .observeOn(schedulers.main())
            .doOnComplete {
                view.showLetterInfo(list)
                view.showRecycler()
            }
            .subscribeOn(schedulers.io())
            .subscribe()
            .addTo(disposables)
    }

    override fun onStop() {
        disposables.dispose()
        list.clear()
    }

    private fun convertToSimple(letterInfo: LetterInfo): AboutLetter =
        AboutLetter(letterInfo.text!!, letterInfo.meanings[0].translation[0].text!!)
}