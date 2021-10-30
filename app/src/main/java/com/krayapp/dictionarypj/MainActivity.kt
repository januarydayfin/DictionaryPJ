package com.krayapp.dictionarypj

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.dictionarypj.view.Screens.MainFragmentScreen
import com.krayapp.movieapppoplib.view.abs.AbsActivity
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainFragmentScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }
}