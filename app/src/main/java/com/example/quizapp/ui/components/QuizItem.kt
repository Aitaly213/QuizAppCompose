package com.example.quizapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.data.model.QuestionModel
import com.example.quizapp.ui.theme.Red20
import com.example.quizapp.utility.decodeHtmlEntities


@Composable
fun QuestionItem(
    currentPage: Int,
    state: PagerState,
    questions: List<QuestionModel>,
    index: Int,
    correctAnswer: String,
    correctAnswersCount: MutableState<Int>,
    nextQuestion: () -> Unit,
    navigateToResult: () -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(
            progress = { currentPage.toFloat() / state.pageCount.toFloat() },
        )

        Text(
            text = currentPage.toString() + "/" + state.pageCount.toString(),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = decodeHtmlEntities(questions[index].question),
            style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 50.dp)
                .align(Alignment.CenterHorizontally)
        )


        when (questions[index].type) {
            "multiple" -> {
                MultipleQuestion(
                    questions[index].correctAnswer,
                    questions[index].incorrectAnswers,
                    onAnswerSelected = { selectedAnswer ->
                        if (selectedAnswer == correctAnswer) {
                            correctAnswersCount.value += 1
                        }
                        if (currentPage == state.pageCount){
                           navigateToResult()
                        }else nextQuestion()
                    }
                )
            }

            "boolean" -> {
                BooleanQuestion(onAnswerSelected = { selectedAnswer ->

                })
            }

            else -> {
                Text("Error")
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 50.dp),
        ) {

            if (currentPage == state.pageCount) {

                Button(
                    onClick = {
                        navigateToResult()
                    },
                    colors = ButtonColors(Red20, Color.White, Red20, Red20)

                ) {
                    Text(
                        "Finish",
                        style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    )
                }
            } else {
                Button(
                    onClick = {
                        nextQuestion()
                    },
                    colors = ButtonColors(Red20, Color.White, Red20, Red20)

                ) {
                    Text(
                        "Skip",
                        style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }

        }
    }
}
