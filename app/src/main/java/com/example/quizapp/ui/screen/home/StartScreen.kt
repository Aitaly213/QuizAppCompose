package com.example.quizapp.ui.screen.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import com.example.quizapp.ui.components.JustText
import com.example.quizapp.ui.components.ReusableDropdownMenuBox
import com.example.quizapp.ui.screen.quiz.QuizViewModel
import org.koin.compose.viewmodel.koinViewModel
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    navigate: (amount:Int,category:Int, difficulty: String,type:String) -> Unit
) {




    var questionsCount by remember {
        mutableFloatStateOf(10f)
    }

    val categoryOptions by remember {
        mutableStateOf(
            mapOf(
                1 to "Any Category",
                9 to "General Knowledge",
                10 to "Entertainment: Books",
                11 to "Entertainment: Film",
                12 to "Entertainment: Music",
                13 to "Entertainment: Musicals and Theatres",
                14 to "Entertainment: Television",
                15 to "Entertainment: Video Games",
                16 to "Entertainment: Board Games",
                17 to "Science & Nature",
                18 to "Science: Computers",
                19 to "Science: Mathematics",
                20 to "Mythology",
                21 to "Sports",
                22 to "Geography",
                23 to "History",
                24 to "Politics",
                25 to "Art",
                26 to "Celebrities",
                27 to "Animals",
                28 to "Vehicles",
                29 to "Entertainment: Comics",
                30 to "Science: Gadgets",
                31 to "Entertainment: Japanese Anime & Manga",
                32 to "Entertainment: Cartoon & Animations"
            )
        )
    }

    var categorySelectedText by remember {
        mutableStateOf(categoryOptions.values.first())
    }

    val difficultyOptions by remember {
        mutableStateOf(
            arrayOf("Any Difficulty", "easy", "medium", "hard")
        )
    }


    var difficultySelectedText by remember {
        mutableStateOf(difficultyOptions[0])
    }

    val typeOptions by remember {
        mutableStateOf(
            arrayOf(
                "Any Type", "multiple", "boolean"
            )
        )
    }

    var typeSelectedText by remember {
        mutableStateOf(typeOptions[0])
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Quiz",
                    color = Color.Black,
                    fontSize = 26.sp
                )
            })

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.ic_science
                ),
                contentDescription = "",
                modifier = Modifier
                    .padding(all = 20.dp)

                    .width(100.dp)
                    .height(100.dp)
            )

            Row(
                modifier = Modifier
                    .padding(all = 10.dp)
            ) {

                Text(
                    text = "Questions amount:",
                    color = Color.Black,
                    fontSize = 18.sp
                )

                Text(
                    text = questionsCount.toInt().toString(),
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }

            Slider(
                value = questionsCount,
                onValueChange = {
                    questionsCount = it.roundToInt().toFloat()
                },
                valueRange = 1f..50f,
                colors =
                SliderDefaults.colors(
                    thumbColor = Color.Blue,
                    activeTrackColor = Color.Magenta
                ),
                steps = 50
            )

            JustText("Category")

            ReusableDropdownMenuBox(
                options = categoryOptions.values.toTypedArray(),
                selectedText = categorySelectedText,
                onOptionSelected = { categorySelectedText = it })

            JustText(text = "Difficulty")

            ReusableDropdownMenuBox(
                options = difficultyOptions,
                selectedText = difficultySelectedText,
                onOptionSelected = { difficultySelectedText = it })


            JustText(text = "Type")

            ReusableDropdownMenuBox(
                options = typeOptions,
                selectedText = typeSelectedText,
                onOptionSelected = { typeSelectedText = it })


            Button(
                modifier = Modifier
                    .padding(all = 20.dp),
                onClick = {



                    navigate(
                        questionsCount.toInt(),
                        categoryOptions.entries.find { it.value == categorySelectedText }?.key ?: 9,
                        difficultySelectedText,
                        typeSelectedText
                        )

                }) {


                Text(text = "START")

            }
        }
    }
}

