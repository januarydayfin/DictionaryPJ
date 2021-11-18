package com.krayapp.datamodule.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class AboutLetter(
    val text: String,
    val translation: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
):Parcelable