package com.application.podcasts.subscreenNavigationBar.ui.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.sharedUI.commonElements.PrimaryLabel
import com.application.podcasts.sharedUI.theme.DarkPrimary
import com.application.podcasts.sharedUI.theme.DarkSecondary

@Composable
fun SubscreenNavigationBarButton(
    isActive: Boolean,
    isEnabled: Boolean,
    content: String,
    onClick: () -> Unit
) {

    val targetColor =
        when(isActive) {

            true -> {

                DarkPrimary
            }

            false -> {

                DarkSecondary
            }
        }

    val color by animateColorAsState(
        targetValue = targetColor,
        animationSpec = SpringSpec(
            stiffness = Spring.StiffnessVeryLow,
            dampingRatio = Spring.DampingRatioNoBouncy
        )
    )

    ElevatedButton(

        onClick = {

            onClick()
        },

        modifier = Modifier
            .height(37.dp),

        enabled = isEnabled,

        shape = RoundedCornerShape(20.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            disabledContainerColor = DarkPrimary
        ),

        elevation = ButtonDefaults.buttonElevation(10.dp),

        content = {

            PrimaryLabel(content)
        }
    )
}