package com.application.podcasts.screenNavigationBar.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavBackStackEntry
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.convertToCurrentScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ScreenNavigationBarViewModel(
    private val currentBackStackEntryFlow: Flow<NavBackStackEntry>
) : ViewModel() {

    private var _viewState = MutableStateFlow(CurrentScreen.HomeScreen)
    val viewState = _viewState.asStateFlow()

    init {

        viewModelScope.launch {

            currentBackStackEntryFlow
                .map { backStackEntry ->

                    backStackEntry
                        .destination
                        .route
                        .toString()
                        .substringBeforeLast(".")
                        .substringAfterLast(".")
                        .convertToCurrentScreen()
                }
                .collect { currentDestination ->

                    currentDestination?.let {

                        _viewState
                            .emit(value = currentDestination)
                    }
                }
        }
    }
}