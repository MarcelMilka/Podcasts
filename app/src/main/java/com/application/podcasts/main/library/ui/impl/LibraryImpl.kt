package com.application.podcasts.main.library.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.library.ui.subscreen.LibrarySubscreen

fun NavGraphBuilder.libraryImpl() {

    composable<Navigation.RouteLibrary.LibrarySubscreen>(

        enterTransition = { EnterTransition.None},

        exitTransition = { ExitTransition.None},

        content = { LibrarySubscreen() }
    )
}