package com.codeliner.numbersgame.domain.usecase

import com.codeliner.numbersgame.domain.entity.GameSettings
import com.codeliner.numbersgame.domain.entity.Level
import com.codeliner.numbersgame.domain.repository.GameRepository

class GetGameSettingsUseCase (
    private val repository: GameRepository
    ) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
} //получить настройки игры в зависимости от уровня