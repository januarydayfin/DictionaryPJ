package com.krayapp.dictionarypj.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.dictionarypj.data.AboutLetter
import com.krayapp.dictionarypj.R.layout.*

class MainFragmentAdapter:ListAdapter<AboutLetter, MainFragmentViewHolder>(MainFragmentDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainFragmentViewHolder =
        MainFragmentViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(letter_templ,parent,false)
        )


    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
       holder.bind(getItem(position))
    }
}

