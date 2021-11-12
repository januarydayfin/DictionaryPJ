package com.krayapp.dictionarypj.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.R
import com.krayapp.dictionarypj.view.Screens.AboutLetterScreen
import org.koin.android.ext.android.inject

class LocalSearchDialogFragment: DialogFragment() {

    private val router: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.search_dialog_fragment, container, false)
        val goButton = view.findViewById<Button>(R.id.go_button)
        val editText = view.findViewById<EditText>(R.id.local_search_input_text)
        goButton.setOnClickListener {
            val text = editText.text.toString()
            if (!text.equals("")) {
            router.navigateTo(AboutLetterScreen(text, true))
            dialog?.dismiss()
            }else{
                Toast.makeText(context,"Такого слова нет в базе", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}




