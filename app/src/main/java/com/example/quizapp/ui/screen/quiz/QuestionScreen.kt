package com.example.quizapp.ui.screen.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quizapp.R
import com.example.quizapp.ui.components.QuestionItem
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(
    viewModel: QuizViewModel = koinViewModel<QuizViewModel>(),
    amount: Int, category: Int, difficulty: String, type: String,
    navigateToResult: (difficulty: String, correctAnswers: Int, questionsAmount: Int) -> Unit
) {

    val questions by viewModel.questionsState.collectAsState()

    LaunchedEffect(amount, category, difficulty, type) {
        viewModel.getQuestions(
            amount = amount,
            category = category,
            difficulty = difficulty,
            type = type
        )
    }

    val topAppBarTitle: String =
        if (!questions.isNullOrEmpty()) questions!![0].category else "Questions"


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        CenterAlignedTopAppBar(
            title = {
                Text(text = topAppBarTitle)
            },
            navigationIcon = {
                IconButton(onClick = { }) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "",
                        modifier = Modifier
                            .width(width = 36.dp)
                            .height(height = 36.dp)

                    )

                }
            })

        val state = rememberPagerState { amount }
        val currentPage = state.currentPage + 1
        val coroutineScope = rememberCoroutineScope()
        val correctAnswersCount = remember { mutableStateOf(0) }
        HorizontalPager(
            userScrollEnabled = false,
            state = state,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            if (!questions.isNullOrEmpty()) {
                QuestionItem(
                    currentPage,
                    state,
                    questions!!,
                    page,
                    questions!![page].correctAnswer,
                    correctAnswersCount,
                    nextQuestion = {
                        coroutineScope.launch {
                            state.animateScrollToPage(page + 1)
                        }
                    },
                    navigateToResult = {
                        navigateToResult(
                            difficulty,
                            correctAnswersCount.value,
                            amount
                        )
                    })
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }

            }
        }
    }
}
