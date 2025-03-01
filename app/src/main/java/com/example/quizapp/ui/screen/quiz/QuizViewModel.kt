package com.example.quizapp.ui.screen.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.data.model.QuestionModel
import com.example.quizapp.data.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizViewModel(
    private val repository: QuizRepository
) : ViewModel() {

    private var _questionsState = MutableStateFlow<List<QuestionModel>?>(emptyList())
    val questionsState = _questionsState.asStateFlow()

    private var _loadingState = MutableStateFlow<Boolean>(false)
    val loadingState = _loadingState.asStateFlow()


    fun getQuestions(amount: Int, category: Int, difficulty: String, type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingState.value = true

            _questionsState.value = repository.getAllQuestions(
                amount = amount,
                category = category,
                difficulty = difficulty,
                type = type
            )
            _loadingState.value = false
        }
    }
}