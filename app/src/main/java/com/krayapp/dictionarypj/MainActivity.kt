package com.krayapp.dictionarypj

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.dictionarypj.view.Screens.MainFragmentScreen
import com.krayapp.dictionarypj.R.menu.*
import com.krayapp.movieapppoplib.view.abs.AbsActivity
import org.koin.android.ext.android.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    private val navigationHolder:NavigatorHolder by inject()
    private val router:Router by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(MainFragmentScreen)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(main_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_menu ->{
                router.replaceScreen(MainFragmentScreen)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }
}