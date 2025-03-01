package com.example.quizapp.data.model


import com.google.gson.annotations.SerializedName


data class BaseResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val questionModels: List<QuestionModel>
)