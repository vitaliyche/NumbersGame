package com.codeliner.numbersgame.domain.usecase

import com.codeliner.numbersgame.domain.entity.Question
import com.codeliner.numbersgame.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    } //инвок - чтобы вызывать юзкейс как метод

    private companion object {
        private const val COUNT_OF_OPTIONS = 6 //количество вариантов ответа храним в юзкейсе, так как это часть бизнес логики
    }
} //юзкейс генерирует вопрос. на основании переданной суммы, генерирует новый вопрос с вариантами ответов