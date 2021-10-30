package com.krayapp.dictionarypj.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.dictionarypj.view.MainFragment

object MainFragmentScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return MainFragment.newInstance()
    }
}