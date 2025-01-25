package com.application.podcasts.main.explore.search.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.explore.search.ui.subscreen.SearchSubscreen

fun NavGraphBuilder.searchImpl() {

    composable<Navigation.RouteExplore.Search>(

        enterTransition = {EnterTransition.None},

        exitTransition = {ExitTransition.None},

        content = { SearchSubscreen() }
    )
}