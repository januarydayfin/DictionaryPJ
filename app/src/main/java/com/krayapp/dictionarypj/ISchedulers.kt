package com.krayapp.dictionarypj

import io.reactivex.Scheduler

interface ISchedulers {
    fun main():Scheduler
    fun io():Scheduler
    fun compitation():Scheduler
}