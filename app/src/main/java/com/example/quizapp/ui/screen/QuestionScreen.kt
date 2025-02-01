package com.example.quizapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(category: String, type: String) {

    val topAppBarTitle: String by remember {
        mutableStateOf(category)
    }

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
                        contentDescription = "hj",
                        modifier = Modifier
                            .width(width = 36.dp)
                            .height(height = 36.dp)
                    )

                }
            })

        

    }
}

@Preview(showSystemUi = true)
@Composable
fun QuestionScreen_Preview() {
    QuestionScreen("Geography", "")
}