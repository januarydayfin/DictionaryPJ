package com.krayapp.dictionarypj.view

import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.data.LetterInfo

interface IMainFragment {
    fun showLetterInfo(list:List<AboutLetter>)
    fun showLoading()
}