package com.example.quizapp.data.repository

import android.util.Log
import com.example.quizapp.data.api.ApiService
import com.example.quizapp.data.model.QuestionModel

class QuizRepository(
    private val apiService: ApiService
) {

    suspend fun getAllQuestions(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<QuestionModel>? {
        val response = apiService.getQuestions(amount,category,difficulty,type)

        response.message()

        return if (response.isSuccessful){
            response.body()?.questionModels
        }else{
            Log.e("aitaly", response.message().toString())
            emptyList()
        }
    }
}
