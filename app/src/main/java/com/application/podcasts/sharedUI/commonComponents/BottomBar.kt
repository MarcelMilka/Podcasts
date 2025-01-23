package com.application.podcasts.sharedUI.commonComponents

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cloud
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.application.podcasts.constants.Elevation
import com.application.podcasts.constants.Padding
import com.application.podcasts.constants.RoundedCorner
import com.application.podcasts.constants.navigation.screens.CurrentScreen
import com.application.podcasts.constants.navigation.screens.convertToEnumCurrentScreen
import com.application.podcasts.sharedUI.commonElements.bottomBarIconButton
import com.application.podcasts.sharedUI.theme.DarkBackground
import com.application.podcasts.sharedUI.theme.DarkSecondary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun bottomBar(
    flowOfNavBackStackEntry: Flow<NavBackStackEntry>,
    onNavigate: (CurrentScreen) -> Unit
) {

    var currentScreen by rememberSaveable {

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

//  Set background for the bar
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = DarkBackground),

        content = {

//          Set padding
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = Padding.BIG.dp,
                        end = Padding.BIG.dp,
                        top = Padding.NONE.dp,
                        bottom = Padding.BIG.dp
                    ),

                content = {

//                  Set bar with shadow
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .shadow(
                                elevation = Elevation.BIG.dp,
                                shape = RoundedCornerShape(RoundedCorner.BIG.dp),
                                clip = false,
                                ambientColor = White,
                            ),
                        shape = RoundedCornerShape(RoundedCorner.BIG.dp),
                        color = DarkSecondary,

                        content = {

//                          Row with buttons
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically,
                                content = {

                                    mapOf(
                                        CurrentScreen.Explore to Icons.Rounded.Explore to "Bottom bar icon button explore",
                                        CurrentScreen.Home to Icons.Rounded.Home to "Bottom bar icon button home",
                                        CurrentScreen.Library to Icons.Rounded.Cloud to "Bottom bar icon button cloud",
                                    ).forEach {

                                        bottomBarIconButton(
                                            onClick = {

                                                currentScreen = it.key.first
                                                onNavigate(currentScreen)
                                            },
                                            isActivated = currentScreen == it.key.first,
                                            isEnabled = currentScreen != it.key.first,
                                            imageVector = it.key.second,
                                            testTag = it.value
                                        )
                                    }
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}