package com.codeliner.numbersgame.domain.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings (
    val maxSumValue: Int, //максимальное значение суммы
    val minCountofRightAnswers: Int, //минимальное количество правильных ответов для победы
    val minPercentOfRightAnswers: Int, //минимальный процент правильных ответов для победы
    val gameTimeInSeconds: Int // время игры в секундах
    ): Parcelable