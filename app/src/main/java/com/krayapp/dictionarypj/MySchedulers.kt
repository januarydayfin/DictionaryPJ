package com.krayapp.dictionarypj

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MySchedulers:ISchedulers {
    override fun main(): Scheduler =
        AndroidSchedulers.mainThread()

    override fun io(): Scheduler =
        Schedulers.io()


    override fun compitation(): Scheduler =
        Schedulers.computation()
}