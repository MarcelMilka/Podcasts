package com.application.podcasts.sharedUI.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.application.podcasts.sharedUI.theme.DarkBackground
import com.application.podcasts.sharedUI.theme.DarkSecondary

@Composable
fun topBar() {

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp)
            .background(color = DarkBackground),

        content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 40.dp,
                        bottom = 5.dp
                    ),

                content = {

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .shadow(
                                elevation = 15.dp,
                                shape = RoundedCornerShape(20.dp),
                                clip = false,
                                ambientColor = White,
                            ),
                        shape = RoundedCornerShape(20.dp),
                        color = DarkSecondary,
                        content = {}
                    )
                }
            )
        }
    )
}