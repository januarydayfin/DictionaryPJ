package com.krayapp.dictionarypj.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.dictionarypj.view.AboutLetterFragment

class AboutLetterScreen(
    private val letter: String,
    private var localRequestStatus: Boolean = false
) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return if (localRequestStatus) {
            AboutLetterFragment.newLocalInstance(letter)
        } else {
            AboutLetterFragment.newInstance(letter)
        }

    }

}