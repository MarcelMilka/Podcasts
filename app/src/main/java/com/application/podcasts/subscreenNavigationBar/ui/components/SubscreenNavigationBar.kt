package com.application.podcasts.subscreenNavigationBar.ui.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.values.Padding
import com.application.podcasts.sharedUI.commonElements.PrimaryLabel
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SubscreenNavigationBar(
    stateFlowOfUiState: StateFlow<SubscreenNavigationBarViewState>,
    onNavigateToPodcasts: () -> Unit,
    onNavigateToHabitTracker: () -> Unit,
) {

    var xIsActive by remember { mutableStateOf(true) }
    var yIsActive by remember { mutableStateOf(false) }
    var zIsActive by remember { mutableStateOf(false) }

    val uiState by stateFlowOfUiState.collectAsState()

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(
                start = Padding.BIG.dp,
                end = Padding.BIG.dp,
                top = 40.dp,
                bottom = Padding.NONE.dp
            ),

        horizontalArrangement = Arrangement.SpaceBetween,

        content = {

            LazyRow(
                modifier = Modifier
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,


                content = {

                    this.item {

                        when(uiState.currentScreen) {
                            CurrentScreen.Explore -> PrimaryLabel("Explore")
                            CurrentScreen.Home -> PrimaryLabel("Home")
                            CurrentScreen.Library -> PrimaryLabel("Library")
                            null -> PrimaryLabel("${uiState.causeOfError}")
                        }

//                        SubscreenNavigationBarButton(
//                            isActive = xIsActive,
//                            isEnabled = !xIsActive,
//                            content = "Podcasts",
//                            onClick = {
//
//                                xIsActive = !xIsActive
//                                yIsActive = !yIsActive
//                            }
//                        )
//
//                        Spacer(Modifier.width(5.dp))
//
//                        SubscreenNavigationBarButton(
//                            isActive = yIsActive,
//                            isEnabled = !yIsActive,
//                            content = "Habit tracker",
//                            onClick = {
//
//                                yIsActive = !yIsActive
//                                xIsActive = !xIsActive
//                            }
//                        )
                    }
                }
            )

            SubscreenNavigationBarIconButton(
                isActive = zIsActive,
                isEnabled = !zIsActive,
                onClick = {

                    zIsActive = !zIsActive
                }
            )
        }
    )
}