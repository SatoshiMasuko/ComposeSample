package com.example.composesample.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)) {
            val textFieldState = remember {
                mutableStateOf(TextFieldValue(""))
            }
            SearchView(textFieldState = textFieldState) {

            }
            Text(text = "検索")
            Button(onClick = { navController.navigate("detail") }) {
                Text(text = "詳細へ")
            }
        }
    }
}