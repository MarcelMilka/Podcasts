package com.application.podcasts.main.home.podcasts.ui.impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.main.home.podcasts.ui.subscreen.podcastsSubscreen

fun NavGraphBuilder.podcastsImpl() {

    composable<HomeSubscreens.Podcasts> {

        podcastsSubscreen()
    }
}