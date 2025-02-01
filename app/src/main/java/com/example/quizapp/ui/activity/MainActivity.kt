package com.example.quizapp.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.ui.screen.MainScreen
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}


//            ExposedDropdownMenuBox(
//                modifier = Modifier
//                    .padding(all = 20.dp),
//                expanded = isExpanded,
//                onExpandedChange = { isExpanded = it }) {
//
//                TextField(
//                    value = selectedText,
//                    onValueChange = {
//
//                    },
//                    readOnly = true,
//                    trailingIcon = {
//                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
//                    },
//                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
//                    modifier = Modifier
//                        .menuAnchor()
//                )
//
//                ExposedDropdownMenu(
//                    expanded = isExpanded,
//                    onDismissRequest = {
//                        isExpanded = false
//                    }) {
//
//                    options.forEach { item ->
//
//                        DropdownMenuItem(
//                            text = {
//                                Text(text = item)
//                            },
//                            onClick = {
//                                selectedText = item
//                                isExpanded = false
//
//                            }
//                        )
//
//                    }
//
//                }
//            }
