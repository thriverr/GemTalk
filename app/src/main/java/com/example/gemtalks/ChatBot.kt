package com.example.gemtalks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gemtalks.components.ChatFooter
import com.example.gemtalks.components.ChatHeader
import com.example.gemtalks.components.ChatList
import com.example.gemtalks.ui.theme.lighterpink
import com.example.gemtalks.ui.theme.lightpink
import com.example.gemtalks.ui.theme.purple
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
            if(viewModel.list.isEmpty()){
                Column( horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.logo), // Replace with your image resource
                        contentDescription = null, // Provide content description if needed
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape) // Clip the image in circular shape
                            .border(2.dp, Color.LightGray, CircleShape) // Add border if needed
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(text = "How can I help you today?", modifier = Modifier.padding(10.dp),
                        color= purple, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                }

            }
            else{
                ChatList(list = viewModel.list)
            }

        }


        ChatFooter {
            if (it.isNotEmpty()) {
                viewModel.sendMessage(it)
            }
        }
    }
}