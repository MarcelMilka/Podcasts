package com.application.podcasts.main.home.podcasts.ui.subscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.application.podcasts.sharedUI.theme.DarkBackground

@Composable
fun podcastsSubscreen(
    onNavigateToHabitTracker: () -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBackground),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        content = {

            Text("Podcasts")

            Button(

                onClick = {

                    onNavigateToHabitTracker()
                },

                content = {

                    Text("Navigate to habit tracker")
                }
            )
        }
    )
}