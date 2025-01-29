package com.application.podcasts.screenNavigationBar.ui.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.application.podcasts.sharedUI.theme.White50

@Composable
fun ScreenNavigationBarIcon(
    onClick: () -> Unit,

    isActive: Boolean,
    isEnabled: Boolean,

    imageVector: ImageVector,
    testTag: String
) {

    val targetSize =
        when(isActive) {

            true -> {

                35
            }

            false -> {

                25
            }
        }

    val size by animateIntAsState(
        targetValue = targetSize,
        animationSpec = SpringSpec(
            stiffness = Spring.StiffnessVeryLow,
            dampingRatio = Spring.DampingRatioNoBouncy
        )
    )

    val targetTint =
        when(isActive) {

            true -> {

                White
            }

            false -> {

                White50
            }
        }

    val tint by animateColorAsState(
        targetValue = targetTint,
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
            .testTag(testTag),

        enabled = isEnabled,

        content = {

            Icon(

                modifier = Modifier
                    .size(size.dp),

                imageVector = imageVector,

                contentDescription = null,

                tint = tint
            )
        }
    )
}