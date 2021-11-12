package com.krayapp.dictionarypj.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.dictionarypj.view.AboutLetterFragment

class AboutLetterScreen(private val letter:String) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return AboutLetterFragment.newInstance(letter)
    }
}