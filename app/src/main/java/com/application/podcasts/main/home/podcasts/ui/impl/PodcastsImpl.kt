package com.application.podcasts.main.home.podcasts.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.home.podcasts.ui.subscreen.PodcastsSubscreen

fun NavGraphBuilder.podcastsImpl() {

    composable<Navigation.RouteHome.PodcastsSubscreen>(

        enterTransition = {EnterTransition.None},

        exitTransition = {ExitTransition.None},

        content = {PodcastsSubscreen()}
    )
}