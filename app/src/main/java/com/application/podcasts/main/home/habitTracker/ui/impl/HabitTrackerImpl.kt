package com.application.podcasts.main.home.habitTracker.ui.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.home.habitTracker.ui.subscreen.habitTrackerSubscreen

fun NavGraphBuilder.habitTrackerImpl() {

    composable<Navigation.RouteHome.HabitTrackerSubscreen> {

        habitTrackerSubscreen()
    }
}