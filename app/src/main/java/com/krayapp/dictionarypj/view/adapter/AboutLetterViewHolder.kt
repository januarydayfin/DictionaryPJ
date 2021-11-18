package com.krayapp.dictionarypj.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.datamodule.data.AboutLetter
import com.krayapp.dictionarypj.databinding.LetterTemplBinding

class AboutLetterViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val viewBinding:LetterTemplBinding by viewBinding()

    fun bind(aboutLetter: AboutLetter, delegate:AboutLetterAdapter.Delegate){
        with(viewBinding){
            letter.text = aboutLetter.text
            translation.text = aboutLetter.translation
            root.setOnClickListener{
                delegate.onLetterPicked(aboutLetter)
            }
        }
    }
}