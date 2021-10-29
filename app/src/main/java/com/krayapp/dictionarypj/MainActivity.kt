package com.krayapp.dictionarypj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.dictionarypj.view.Screens.MainFragmentScreen

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, android.R.id.content)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: DictionaryApp.instance.router.newRootScreen(MainFragmentScreen)
    }
}