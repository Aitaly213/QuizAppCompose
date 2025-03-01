package com.example.quizapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.Blue100

@Composable
fun BooleanQuestion(onAnswerSelected: (Boolean) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                //Write Logic
            },
            border = BorderStroke(1.dp, color = Blue100),
            shape = RoundedCornerShape(CornerSize(6.dp)),
            colors = ButtonColors(Color.White, Blue100, Blue100, Blue100),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 35.dp)
        ) {
            Text("Yes", color = Blue100, style = TextStyle(fontSize = 14.sp))
        }

        Button(
            onClick = {
                //Write Logic
            },
            border = BorderStroke(1.dp, color = Blue100),
            shape = RoundedCornerShape(CornerSize(6.dp)),
            colors = ButtonColors(Color.White, Blue100, Blue100, Blue100),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        ) {
            Text("No", color = Blue100, style = TextStyle(fontSize = 14.sp))
        }
    }
}
