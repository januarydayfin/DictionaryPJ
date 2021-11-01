package com.krayapp.dictionarypj.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class LetterInfo(
    @Expose
    val text: String?,
    @Expose
    val meanings: List<LetterMeanings>?
): Parcelable

@Parcelize
data class LetterMeanings(
    @Expose
    val translation: LetterTranslation
):Parcelable

@Parcelize
data class LetterTranslation(
    @Expose
    val text: String?,
    @Expose
    val note: String?
):Parcelable

