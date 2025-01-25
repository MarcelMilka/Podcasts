package com.application.podcasts.main.explore.selectLanguage.ui.subscreen

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
fun SelectLanguageSubscreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBackground),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        content = {

            PrimaryLabel(content = "Screen 'Explore' -> 'Select language'")
        }
    )
}