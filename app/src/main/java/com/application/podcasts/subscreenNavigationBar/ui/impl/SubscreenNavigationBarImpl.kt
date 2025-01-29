package com.application.podcasts.subscreenNavigationBar.ui.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.subscreenNavigationBar.ui.components.SubscreenNavigationBar
import com.application.podcasts.subscreenNavigationBar.vm.SubscreenNavigationBarViewModel

@Composable
fun SubscreenNavigationBarImpl(navHostController: NavHostController) {

    val subscreenNavigationBarViewModel =
        SubscreenNavigationBarViewModel(
            currentBackStackEntryFlow = navHostController.currentBackStackEntryFlow
        )

    SubscreenNavigationBar(

        stateFlowOfViewState = subscreenNavigationBarViewModel.viewState,

        onSearch = {

            navHostController.navigate(
                route = Navigation.RouteExplore.SearchSubscreen
            )
        },

        onExplore = {

            navHostController.navigate(
                route = Navigation.RouteExplore.ExploreSubscreen
            )
        },

        onExploreByLanguage = {

            navHostController.navigate(
                route = Navigation.RouteExplore.SelectLanguageSubscreen
            )
        },

        onFilter = {

            navHostController.navigate(
                route = Navigation.RouteExplore.FilterSubscreen
            )
        },

        onNavigateToPodcasts = {

            navHostController.navigate(
                route = Navigation.RouteHome.PodcastsSubscreen
            )
        },

        onNavigateToHabitTracker = {

            navHostController.navigate(
                route = Navigation.RouteHome.HabitTrackerSubscreen
            )
        },

        onNavigateToAccount = {

            navHostController.navigate(
                route = Navigation.RouteAccount.AccountSubscreen
            )
        }
    )
}