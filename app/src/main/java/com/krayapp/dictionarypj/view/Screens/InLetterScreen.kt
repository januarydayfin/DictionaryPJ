package com.krayapp.dictionarypj.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.view.InLetterFragment

class InLetterScreen(private val aboutLetter:AboutLetter):FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        InLetterFragment.newInstance(aboutLetter)
}