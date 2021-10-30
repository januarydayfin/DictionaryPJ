package com.krayapp.dictionarypj.view.Screens

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.dictionarypj.view.MainFragment

object MainFragmentScreen :FragmentScreen{
    private val tester = "123"
    override fun createFragment(factory: FragmentFactory): Fragment {
        println(tester)
        return MainFragment.newInstance()
    }
}