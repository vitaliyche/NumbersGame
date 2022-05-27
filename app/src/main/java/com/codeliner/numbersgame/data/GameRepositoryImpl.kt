package com.codeliner.numbersgame.data

import com.codeliner.numbersgame.domain.entity.GameSettings
import com.codeliner.numbersgame.domain.entity.Level
import com.codeliner.numbersgame.domain.entity.Question
import com.codeliner.numbersgame.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1


    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue+1) //получить значение суммы
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum) //получить значение видимого числа
        val options = HashSet<Int>() //в коллекции будут лежать все варианты ответов
        val rightAnswer = sum - visibleNumber//получить значение правильного ответа
        options.add(rightAnswer)//положить правильный ответ в коллекцию опшинс
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE) // нижняя граница диапазона
        val to = min(maxSumValue, rightAnswer+countOfOptions)//верхняя граница диапазона
        while (options.size<countOfOptions) {
            options.add(Random.nextInt(from, to))
        } // генерировать 6 вариантов ответа
        return Question(sum, visibleNumber, options.toList())

    } // генерировать вопрос

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }
        }
    } // генерировать настройки игры в зависимости от уровня
}