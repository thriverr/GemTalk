package com.example.gemtalks

sealed interface ChatBotState {
    data object Ideal:ChatBotState
    data object Loading:ChatBotState
    data class Success(val CharData:String):ChatBotState
    data class Error(val ChatError:String):ChatBotState
}