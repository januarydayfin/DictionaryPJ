package com.krayapp.dictionarypj.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.R.layout.*

class AboutLetterAdapter:ListAdapter<AboutLetter, AboutLetterViewHolder>(AboutLetterDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutLetterViewHolder =
        AboutLetterViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(letter_templ,parent,false)
        )


    override fun onBindViewHolder(holder: AboutLetterViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}
