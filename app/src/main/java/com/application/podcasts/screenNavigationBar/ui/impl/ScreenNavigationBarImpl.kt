package com.application.podcasts.screenNavigationBar.ui.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.screenNavigationBar.ui.components.ScreenNavigationBar
import com.application.podcasts.screenNavigationBar.vm.ScreenNavigationBarViewModel

@Composable
fun ScreenNavigationBarImpl(navHostController: NavHostController) {

    val screenNavigationBarViewModel =
        ScreenNavigationBarViewModel(
        currentBackStackEntryFlow = navHostController.currentBackStackEntryFlow
    )

    ScreenNavigationBar(

        stateFlowOfViewState = screenNavigationBarViewModel.viewState,

        onNavigate = {

            val targetScreen = when(it) {
                CurrentScreen.ExploreScreen -> Navigation.RouteExplore.ExploreScreen
                CurrentScreen.HomeScreen -> Navigation.RouteHome.HomeScreen
                CurrentScreen.LibraryScreen -> Navigation.RouteLibrary.LibraryScreen
                CurrentScreen.AccountScreen -> Navigation.RouteAccount.AccountScreen
            }

            navHostController.navigate(route = targetScreen)
        }
    )
}