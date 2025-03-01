package com.example.quizapp.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.quizapp.ui.navRoute.NavRoute
import com.example.quizapp.ui.screen.ResultScreen
import com.example.quizapp.ui.screen.home.StartScreen
import com.example.quizapp.ui.screen.quiz.QuestionScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHostInit(navController = navController)
        }

    }


}

@Composable
fun NavHostInit(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Start
    ) {
        composable<NavRoute.Start> {
            StartScreen(navigate = { amount, category, difficulty, type ->
                navController.navigate(
                    NavRoute.Questions(
                        amount = amount,
                        category = category,
                        difficulty = difficulty,
                        type = type
                    )
                )
            })
        }

        composable<NavRoute.Questions> {
            val args = it.toRoute<NavRoute.Questions>()

            QuestionScreen(
                amount = args.amount,
                category = args.category,
                difficulty = args.difficulty,
                type = args.type,
                navigateToResult = { difficulty, correctAnswersCount, questionsAmount ->
                    navController.navigate(
                        NavRoute.Result(
                            difficulty = difficulty,
                            correctAnswersCount = correctAnswersCount,
                            questionsAmount = questionsAmount
                        )
                    )
                }

            )
        }

        composable<NavRoute.Result> {
            val args = it.toRoute<NavRoute.Result>()

            ResultScreen(
                difficulty = args.difficulty,
                correctAnswers = args.correctAnswersCount,
                questionsAmount = args.questionsAmount
            )
        }

    }
}