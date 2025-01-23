package com.application.podcasts.main.home.habitTracker.ui.subscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun habitTrackerSubscreen(
    onNavigateToPodcasts: () -> Unit
) {

    Column(

        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        content = {

            Text("Habit tracker")

            Button(

                onClick = {

                    onNavigateToPodcasts()
                },

                content = {

                    Text("Navigate to podcasts")
                }
            )
        }
    )
}