package com.krayapp.dictionarypj.data.retrofit2.letter

import com.google.gson.annotations.Expose

data class LetterInfo(
    @Expose
    val text: String?,
    @Expose
    val meanings: List<LetterMeanings>?
)

data class LetterMeanings(
    @Expose
    val translation: LetterTranslation
)

data class LetterTranslation(
    @Expose
    val text: String?,
    @Expose
    val note: String?
)

