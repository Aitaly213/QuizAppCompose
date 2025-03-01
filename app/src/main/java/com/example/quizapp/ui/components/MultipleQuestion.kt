package com.example.quizapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Blue100
import com.example.quizapp.ui.theme.Green100
import com.example.quizapp.ui.theme.Red100
import com.example.quizapp.utility.decodeHtmlEntities

@Composable
fun MultipleQuestion(
    correctAnswer: String,
    incorrectAnswers: List<String>,
    onAnswerSelected: (String) -> Unit
) {
    val answers = remember {
        mutableStateOf(
            incorrectAnswers + correctAnswer
        )
    }

    LaunchedEffect(Unit) {
        answers.value = answers.value.shuffled()
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        ButtonAnswer(
            text = answers.value[0],
            backgroundColor = Blue100,
            textColor = Color.White,
            onClick = {
                onAnswerSelected(incorrectAnswers[0])
            }
        )

        ButtonAnswer(
            text = answers.value[1],
            backgroundColor = Green100,
            textColor = Color.White,
            onClick = {
                onAnswerSelected(correctAnswer)
            }
        )

        ButtonAnswer(
            text = answers.value[2],
            backgroundColor = Red100,
            textColor = Color.White,
            onClick = {
                onAnswerSelected(incorrectAnswers[1])
            }
        )

        ButtonAnswer(
            text = answers.value[3],
            backgroundColor = Color.White,
            textColor = Blue100,
            borderColor = Blue100,
            onClick = {
                onAnswerSelected(incorrectAnswers[1])
            }
        )
    }
}

@Composable
fun ButtonAnswer(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    borderColor: Color = backgroundColor,
    onClick: () -> Unit,
) {

    Button(
        onClick = {
            onClick()
        },
        border = BorderStroke(1.dp, color = borderColor),
        shape = RoundedCornerShape(CornerSize(6.dp)),
        colors = ButtonColors(backgroundColor, backgroundColor, backgroundColor, backgroundColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp, top = 5.dp)
    ) {
        Text(
            decodeHtmlEntities(text),
            color = textColor,
            style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
        )
    }

}