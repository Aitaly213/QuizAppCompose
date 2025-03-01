package com.example.quizapp.ui.navRoute

import com.example.quizapp.data.model.QuestionModel
import kotlinx.serialization.Serializable

object NavRoute {

    @Serializable
    object Start

    @Serializable
    data class Questions(
        val amount:Int,
        val category:Int,
        val difficulty: String,
        val type: String
    )

    @Serializable
    data class Result(
        val difficulty: String,
        val correctAnswersCount: Int,
        val questionsAmount: Int
    )
}