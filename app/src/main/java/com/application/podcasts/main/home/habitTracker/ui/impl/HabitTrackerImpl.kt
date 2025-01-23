package com.application.podcasts.main.home.habitTracker.ui.impl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.main.home.habitTracker.ui.subscreen.habitTrackerSubscreen

fun NavGraphBuilder.habitTrackerImpl(navigationController: NavController) {

    composable<HomeSubscreens.HabitTracker> {

        habitTrackerSubscreen(

            onNavigateToPodcasts = {

                navigationController.navigate(
                    route = HomeSubscreens.Podcasts
                )
            }
        )
    }
}