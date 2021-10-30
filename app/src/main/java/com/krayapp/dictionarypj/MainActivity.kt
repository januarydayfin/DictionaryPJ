package com.krayapp.dictionarypj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.dictionarypj.databinding.MainFragmentBinding
import com.krayapp.dictionarypj.view.MainFragment
import com.krayapp.dictionarypj.view.Screens.MainFragmentScreen
import com.krayapp.movieapppoplib.view.abs.AbsActivity

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       savedInstanceState ?: DictionaryApp.instance.router.newRootScreen(MainFragmentScreen)
    }
}