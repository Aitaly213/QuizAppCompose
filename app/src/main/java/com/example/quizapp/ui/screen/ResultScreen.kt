package com.example.quizapp.ui.screen

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.theme.Green100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Result")
            }
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                ,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "",
                tint = Green100,
                modifier = Modifier
                    .width(124.dp)
                    .height(124.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .padding(22.dp)
                    .fillMaxWidth()
                    .width(180.dp)
                    .shadow(100.dp, spotColor = Color.Black, ambientColor = Color.Black,)
            ) {

                Text("Category: Geography",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                    , horizontalArrangement = Arrangement.Center
                ){
                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {
                        Text("Difficulty: ",
                            fontSize = 12.sp,
                            color = Color.Gray
                            )
                        Text("All ")
                    }
                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)


                    ) {
                        Text("Correct answers ",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Text("All ")
                    }
                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                    ) {
                        Text("Result: ",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                        Text("All ")
                    }
                }
            }



            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(Green100),
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text("Finish", style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White))
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview_Result() {
    ResultScreen()
}