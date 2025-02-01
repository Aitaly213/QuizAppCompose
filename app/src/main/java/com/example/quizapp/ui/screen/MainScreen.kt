package com.example.quizapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.R
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var questionsCount by remember {
        mutableFloatStateOf(10f)
    }

    val categoryOptions by remember {
        mutableStateOf(arrayOf("All", "sdv", "eknskn", "ofsbns"))
    }
    var categorySelectedText by remember {
        mutableStateOf(categoryOptions[0])
    }
    val difficultyOptions by remember {
        mutableStateOf(
            arrayOf(
                "All", "Easy", "Normal", "Hard",
            )
        )
    }
    var difficultySelectedText by remember {
        mutableStateOf(difficultyOptions[0])
    }
    val typeOptions by remember {
        mutableStateOf(
            arrayOf(
                "Any Type", "Multiple Choice", "True / False"
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
                options = categoryOptions,
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

                }) {

                Text(text = "START")

            }
        }
    }
}


@Composable
private fun JustText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(top = 12.dp)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableDropdownMenuBox(
    options: Array<String>,
    selectedText: String,
    onOptionSelected: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .padding(all = 20.dp),
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }) {

        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }) {

            options.forEach { item ->

                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        onOptionSelected(item)
                        isExpanded = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun MainScreen_Preview() {
    MainScreen()
}