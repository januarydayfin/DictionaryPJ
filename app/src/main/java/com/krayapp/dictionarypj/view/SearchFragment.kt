package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.databinding.SearchLayoutBinding
import com.krayapp.dictionarypj.view.Screens.AboutLetterScreen
import org.koin.android.ext.android.inject
import com.krayapp.dictionarypj.R.layout.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope


class SearchFragment: Fragment(search_layout) {
    companion object {
        fun newInstance():Fragment = SearchFragment()
    }
     private val router: Router by inject()
    private val viewBinding:SearchLayoutBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.loadButton.setOnClickListener {
            val text = viewBinding.inputText.text.toString()
            if (!text.equals("")) {
                router.navigateTo(AboutLetterScreen(text))
            } else {
                Toast.makeText(context, "Letter field is empty", Toast.LENGTH_SHORT).show()
                viewBinding.inputText.hint = "Letter is empty"
            }
        }
    }
}