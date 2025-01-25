package com.application.podcasts.subscreenNavigationBar.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.application.podcasts.sharedUI.theme.DarkPrimary
import com.application.podcasts.sharedUI.theme.DarkSecondary

@Composable
fun SubscreenNavigationBarIconButton(
    isActive: Boolean,
    isEnabled: Boolean,
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

    IconButton(

        onClick = {

            onClick()
        },

        modifier = Modifier
            .width(37.dp)
            .height(37.dp),

        enabled = isEnabled,

        colors = IconButtonDefaults.iconButtonColors(
            containerColor = color,
            contentColor = White,
            disabledContainerColor = DarkPrimary,
            disabledContentColor = White
        ),

        content = {

            Icon(

                imageVector = Icons.Rounded.Person,
                contentDescription = null
            )
        }
    )
}
