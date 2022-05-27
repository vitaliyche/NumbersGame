package com.codeliner.numbersgame.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult (
    val winner: Boolean, // победили или нет
    val countOfRightAnswers: Int, // количество правильных ответов
    val countOfQuestions: Int, //общее количество вопросов для вычисления % правильных ответов
    val gameSettings: GameSettings //настройки игры для отображения данных пользователю
): Parcelable // результат игры