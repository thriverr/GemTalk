package com.example.gemtalks.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gemtalks.ui.theme.brown
import com.example.gemtalks.ui.theme.cream
import com.example.gemtalks.ui.theme.darkblue
import com.example.gemtalks.ui.theme.green
import com.example.gemtalks.ui.theme.lightpink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatFooter(onClick: (text: String) -> Unit) {
    var inputText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(green) // Cream color
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            placeholder = { Text(text = "Message GemTalk") },
            modifier = Modifier
                .weight(1f)
                .background(green),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = darkblue, // Brown color
                unfocusedBorderColor = Color.Gray
            )
        )
        IconButton(
            onClick = {
                onClick(inputText)
                inputText = ""
            }
        ) {
            Icon(
                Icons.Rounded.Send,
                contentDescription = "send button",
                modifier = Modifier.size(40.dp).padding(8.dp),
                tint = darkblue // Brown color
            )
        }
    }
}
