package com.application.podcasts.screenNavigationBar.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.constants.values.Padding
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.screenNavigationBar.ui.elements.ScreenNavigationBarIcon
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ScreenNavigationBar(
    stateFlowOfViewState: StateFlow<CurrentScreen?>,
    onNavigate: (CurrentScreen) -> Unit
) {

    val currentScreen by stateFlowOfViewState.collectAsState()

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(
                start = Padding.BIG.dp,
                end = Padding.BIG.dp,
                top = Padding.NONE.dp,
                bottom = Padding.BIG.dp
            ),

        horizontalArrangement = Arrangement.SpaceAround,

        content = {

            mapOf(
                CurrentScreen.ExploreScreen to Icons.Rounded.Explore to "Bottom bar icon button explore",
                CurrentScreen.HomeScreen to Icons.Rounded.Home to "Bottom bar icon button home",
                CurrentScreen.LibraryScreen to Icons.Rounded.Cloud to "Bottom bar icon button library",
            ).forEach { screen ->

                ScreenNavigationBarIcon(
                    onClick = {

                        onNavigate(screen.key.first)
                    },
                    isActive = currentScreen == screen.key.first,
                    isEnabled = currentScreen != screen.key.first,
                    imageVector = screen.key.second,
                    testTag = screen.value
                )
            }
        }
    )
}