package com.example.gemtalks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gemtalks.components.ChatFooter
import com.example.gemtalks.components.ChatHeader
import com.example.gemtalks.components.ChatList
import com.google.ai.client.generativeai.type.content

@Composable
fun ChatBot(viewModel: ChatBotVM = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChatHeader()
        Box(modifier=Modifier.weight(1f), contentAlignment = Alignment.Center){
ChatList(list = viewModel.list)
        }


        ChatFooter {
            if (it.isNotEmpty()) {
                viewModel.sendMessage(it)
            }
        }
    }
}