package com.example.gemtalks

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatBotVM : ViewModel() {
    val list by lazy { mutableStateListOf<ChatData>() }

    private val genAI by lazy {
        GenerativeModel(
            modelName = "gemini-pro",
            apiKey = "AIzaSyCQyNFmVlarlkxFsWXFHWKuaLlomjvtlWM"
        )
    }

    fun sendMessage(message: String) = viewModelScope.launch {
        try {
            // Add user's message
            list.add(ChatData(message, ChatRoleEnum.USER.role))

            // Start chat session
            val chat = genAI.startChat()

            // Send message to model
            val response = chat.sendMessage(content {
                text(message)
            })

            // Add model's response if it's not null
            response.text?.let {
                list.add(ChatData(it, ChatRoleEnum.MODEL.role))
            } ?: run {
                // Handle null response
                list.add(ChatData("Error: No response from model.", ChatRoleEnum.MODEL.role))
            }
        } catch (e: Exception) {
            // Log exceptions
            Log.e("ChatBotVM", "Error sending message", e)
            list.add(ChatData("Error: ${e.message}", ChatRoleEnum.MODEL.role))
        }
    }
}
