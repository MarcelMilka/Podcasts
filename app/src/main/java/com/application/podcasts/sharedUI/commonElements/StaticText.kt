package com.application.podcasts.sharedUI.commonElements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.sp
import com.application.podcasts.sharedUI.theme.quickSandMedium

@Composable
// Use this as primary text inside buttons.
fun PrimaryLabel(content: String) {

    Text(
        text = content,
        color = White,
        fontSize = 16.sp,
        fontFamily = quickSandMedium,
        maxLines = 1,
    )
}