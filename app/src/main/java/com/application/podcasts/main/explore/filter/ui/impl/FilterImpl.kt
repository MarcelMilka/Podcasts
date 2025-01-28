package com.application.podcasts.main.explore.filter.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.explore.filter.ui.subscreen.FilterSubscreen

fun NavGraphBuilder.filterImpl() {

    composable<Navigation.RouteExplore.FilterSubscreen>(

        enterTransition = {EnterTransition.None},

        exitTransition = {ExitTransition.None},

        content = { FilterSubscreen() }
    )
}