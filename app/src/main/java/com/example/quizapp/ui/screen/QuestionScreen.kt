package com.example.quizapp.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun QuestionScreen(category: String, type: String, question: String) {

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

        val state = rememberPagerState { 10 }
        val currentPage = state.currentPage+1
        HorizontalPager(
            state = state,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LinearProgressIndicator(
                    progress = { currentPage.toFloat()/ state.pageCount.toFloat() },
                )

                Text(text = currentPage.toString()+"/" +  state.pageCount.toString(), fontSize = 14.sp)

                Text(text = question, style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .padding(vertical = 30.dp))


            }
        }

        //LinearProgressIndicator(progress = )
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuestionScreen_Preview() {
    QuestionScreen("Geography", "","11111111")
}