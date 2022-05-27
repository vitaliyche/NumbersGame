package com.codeliner.numbersgame.domain.repository

import com.codeliner.numbersgame.domain.entity.GameSettings
import com.codeliner.numbersgame.domain.entity.Level
import com.codeliner.numbersgame.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int //количество вариантов ответа
    ): Question

    fun getGameSettings(level: Level): GameSettings
} // оба юзкейса работают с интерфейсом репозитория