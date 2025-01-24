package com.application.podcasts.sharedUI.commonComponents.screenNavigationBar

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.application.podcasts.constants.values.Padding
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.convertToEnumCurrentScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun ScreenNavigationBar(
    flowOfNavBackStackEntry: Flow<NavBackStackEntry>,
    onNavigate: (CurrentScreen) -> Unit
) {

    var currentScreen by remember {

        mutableStateOf(CurrentScreen.Home)
    }

//  When a user navigates back using the smartphone's built-in back button, automatically update the UI to reflect the current screen.
    LaunchedEffect(flowOfNavBackStackEntry) {

        flowOfNavBackStackEntry
            .map { backStackEntry ->

                Log.d("Halla!", "$backStackEntry")

                backStackEntry
                    .destination
                    .toString()
                    .substringAfterLast(".")
                    .convertToEnumCurrentScreen()
            }
            .collect { currentDestination ->

                currentDestination?.let {

                    if (currentScreen != it) {

                        currentScreen = it
                    }
                }
            }
    }

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
                CurrentScreen.Explore to Icons.Rounded.Explore to "Bottom bar icon button explore",
                CurrentScreen.Home to Icons.Rounded.Home to "Bottom bar icon button home",
                CurrentScreen.Library to Icons.Rounded.Cloud to "Bottom bar icon button library",
            ).forEach {

                ScreenNavigationBarIcon(
                    onClick = {

                        currentScreen = it.key.first
                        onNavigate(currentScreen)
                    },
                    isActive = currentScreen == it.key.first,
                    isEnabled = currentScreen != it.key.first,
                    imageVector = it.key.second,
                    testTag = it.value
                )
            }
        }
    )
}