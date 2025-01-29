package com.application.podcasts.subscreenNavigationBar.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.values.Padding
import com.application.podcasts.sharedUI.commonElements.PrimaryLabel
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import com.application.podcasts.subscreenNavigationBar.ui.elements.SubscreenNavigationBarIconButton
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SubscreenNavigationBar(
    stateFlowOfViewState: StateFlow<SubscreenNavigationBarViewState>,
    onSearch: () -> Unit,
    onExplore: () -> Unit,
    onExploreByLanguage: () -> Unit,
    onFilter: () -> Unit,
    onNavigateToPodcasts: () -> Unit,
    onNavigateToHabitTracker: () -> Unit,
    onNavigateToAccount: () -> Unit,
) {

    val uiState by stateFlowOfViewState.collectAsState()

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
        verticalAlignment = Alignment.CenterVertically,

        content = {

            LazyRow(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),

                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,

                content = {

                    this.item {

                        when(uiState.currentScreen) {

                            CurrentScreen.ExploreScreen -> {

                                SubscreenBarForExploreScreen(

                                    uiState = uiState,

                                    onSearch = {

                                        onSearch()
                                    },

                                    onExplore = {

                                        onExplore()
                                    },

                                    onExploreByLanguage = {

                                        onExploreByLanguage()
                                    },

                                    onFilter = {

                                        onFilter()
                                    },
                                )
                            }

                            CurrentScreen.HomeScreen -> {

                                SubscreenBarForHomeScreen(

                                    uiState = uiState,

                                    onNavigateToPodcasts = {

                                        onNavigateToPodcasts()
                                    },

                                    onNavigateToHabitTracker = {

                                        onNavigateToHabitTracker()
                                    }
                                )
                            }

                            CurrentScreen.LibraryScreen -> {

                                SubscreenBarForLibraryScreen()
                            }

                            CurrentScreen.AccountScreen -> {

                                SubscreenBarForAccountScreen()
                            }

                            null -> {

                                PrimaryLabel("${uiState.causeOfError}")
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            SubscreenNavigationBarIconButton(
                isActive = uiState.currentScreen == CurrentScreen.AccountScreen,
                isEnabled = uiState.currentScreen != CurrentScreen.AccountScreen,
                icon = Icons.Rounded.Person,
                testTag = "IconButtonAccount",
                onClick = {

                    onNavigateToAccount()
                },
            )
        }
    )
}