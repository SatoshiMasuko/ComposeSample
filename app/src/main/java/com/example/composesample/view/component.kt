package com.example.composesample.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesample.ui.theme.Purple80
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    textFieldState: MutableState<TextFieldValue>,
    onSubmit: (text: String) ->Unit,
) {
    val focusManager = LocalFocusManager.current

    TextField(
        value = textFieldState.value,
        onValueChange = {value ->
            textFieldState.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "search icon",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if(textFieldState.value != TextFieldValue("")) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "delete icon",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.White,
            containerColor = Purple80,
            focusedLeadingIconColor = Color.White,
            unfocusedLeadingIconColor = Color.White,
            focusedTrailingIconColor = Color.White,
            unfocusedTrailingIconColor = Color.White
        ),
        keyboardActions = KeyboardActions {
            focusManager.clearFocus()
            onSubmit(textFieldState.value.text)
        }
    )
}