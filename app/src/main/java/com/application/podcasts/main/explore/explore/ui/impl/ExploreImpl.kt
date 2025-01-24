package com.application.podcasts.main.explore.explore.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.ExploreSubscreens
import com.application.podcasts.main.explore.explore.ui.subscreen.ExploreSubscreen

fun NavGraphBuilder.exploreImpl() {

    composable<ExploreSubscreens.Explore>(

        enterTransition = { EnterTransition.None},

        exitTransition = { ExitTransition.None},

        content =  {ExploreSubscreen()}
    )
}