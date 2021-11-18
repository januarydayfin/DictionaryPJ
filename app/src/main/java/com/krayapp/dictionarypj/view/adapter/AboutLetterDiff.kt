package com.krayapp.dictionarypj.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.dictionarypj.data.AboutLetter

object AboutLetterDiff : DiffUtil.ItemCallback<AboutLetter>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: AboutLetter, newItem: AboutLetter): Boolean {
        return oldItem.text == newItem.text
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: AboutLetter, newItem: AboutLetter): Boolean {
        return oldItem.text == newItem.text
    }

    override fun getChangePayload(oldItem: AboutLetter, newItem: AboutLetter): Any = payload
}