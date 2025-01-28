package com.application.podcasts.main.home.habitTracker.ui.subscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.application.podcasts.sharedUI.commonElements.PrimaryLabel
import com.application.podcasts.sharedUI.theme.DarkBackground

@Composable
fun habitTrackerSubscreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBackground),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        content = {

            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .background(color = DarkBackground),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                content = {

                    PrimaryLabel(content = "Screen 'Home' -> 'Habit tracker'")
                }
            )
        }
    )
}