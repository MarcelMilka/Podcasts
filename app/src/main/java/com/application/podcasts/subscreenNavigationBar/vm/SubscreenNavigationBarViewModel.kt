package com.application.podcasts.subscreenNavigationBar.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavBackStackEntry
import com.application.podcasts.constants.navigation.convertToCurrentScreen
import com.application.podcasts.constants.navigation.convertToCurrentSubscreen
import com.application.podcasts.subscreenNavigationBar.business.CurrentLocation
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarErrorMessages
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class SubscreenNavigationBarViewModel(
    private val currentBackStackEntryFlow: Flow<NavBackStackEntry>
): ViewModel() {

    private var _uiState = MutableStateFlow(SubscreenNavigationBarViewState())
    val uiState = _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            currentBackStackEntryFlow
                .map { backStackEntry ->

                    val screen =
                        backStackEntry
                        .destination
                        .toString()
                        .substringAfterLast(".")
                        .convertToCurrentScreen()

                    val subscreen =
                        backStackEntry
                        .destination
                        .toString()
                        .substringAfterLast(".")
                        .convertToCurrentSubscreen()

                    CurrentLocation(
                        screen = screen,
                        subscreen = subscreen
                    )
                }
                .collect { currentLocation ->

                    val causeOfError = when {

                        currentLocation.screen == null && currentLocation.subscreen == null -> {
                            SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_AND_SUBSCREEN_ARE_NULL
                        }

                        currentLocation.screen == null -> {
                            SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_IS_NULL
                        }

                        currentLocation.subscreen == null -> {
                            SubscreenNavigationBarErrorMessages.CURRENT_SUBSCREEN_IS_NULL
                        }

                        else -> null
                    }

                    currentLocation.subscreen ?: SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_IS_NULL

                    _uiState
                        .emit(
                            SubscreenNavigationBarViewState(
                                currentScreen = currentLocation.screen,
                                currentSubscreen = currentLocation.subscreen,
                                causeOfError = causeOfError
                            )
                        )
                }
        }
    }
}