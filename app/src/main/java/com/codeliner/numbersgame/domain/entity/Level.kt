package com.codeliner.numbersgame.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Level: Parcelable {
    TEST, EASY, NORMAL, HARD
} //енум - чтобы знать все варианты, которые может принимать класс Левел
