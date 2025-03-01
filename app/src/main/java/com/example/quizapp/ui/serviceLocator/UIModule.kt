package com.example.quizapp.ui.serviceLocator

import com.example.quizapp.ui.screen.quiz.QuizViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { QuizViewModel(get()) }
}