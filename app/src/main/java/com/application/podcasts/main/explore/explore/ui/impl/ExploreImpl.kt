package com.application.podcasts.main.explore.explore.ui.impl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.ExploreSubscreens
import com.application.podcasts.main.explore.explore.ui.subscreen.exploreSubscreen

fun NavGraphBuilder.exploreImpl() {

    composable<ExploreSubscreens.Explore> {

        exploreSubscreen()
    }
}