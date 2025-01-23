package com.application.podcasts.main.home.podcasts.ui.impl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.main.home.podcasts.ui.subscreen.podcastsSubscreen

fun NavGraphBuilder.podcastsImpl(navigationController: NavController) {

    composable<HomeSubscreens.Podcasts> {

        podcastsSubscreen(

            onNavigateToHabitTracker = {
                navigationController.navigate(route = HomeSubscreens.HabitTracker)
            }
        )
    }
}