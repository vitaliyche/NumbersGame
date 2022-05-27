package com.codeliner.numbersgame.domain.entity

data class Question(
    val sum: Int, //сумма - отображается в кружке
    val visibleNumber: Int, //видимое число - слева в квадрате
    val options: List<Int> //варианты ответов
) {
    val rightAnswer: Int
    get() = sum - visibleNumber
}