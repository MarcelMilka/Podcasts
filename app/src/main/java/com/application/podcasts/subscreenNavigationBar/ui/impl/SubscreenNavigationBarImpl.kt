package com.application.podcasts.subscreenNavigationBar.ui.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.subscreenNavigationBar.ui.components.SubscreenNavigationBar
import com.application.podcasts.subscreenNavigationBar.vm.SubscreenNavigationBarViewModel

@Composable
fun SubscreenNavigationBarImpl(navigationController: NavHostController) {

    val subscreenNavigationBarViewModel =
        SubscreenNavigationBarViewModel(
            currentBackStackEntryFlow = navigationController.currentBackStackEntryFlow
        )

    SubscreenNavigationBar(

        stateFlowOfUiState = subscreenNavigationBarViewModel.uiState,

        onNavigateToPodcasts = {

            navigationController.navigate(
                route = Navigation.RouteHome.Podcasts
            )
        },

        onNavigateToHabitTracker = {

            navigationController.navigate(
                route = Navigation.RouteHome.HabitTracker
            )
        },

        onNavigateToAccount = {

            navigationController.navigate(
                route = Navigation.Account
            )
        }
    )
}