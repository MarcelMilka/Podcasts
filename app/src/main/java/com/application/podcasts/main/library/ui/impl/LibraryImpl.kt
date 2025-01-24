package com.application.podcasts.main.library.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.constants.navigation.subscreens.LibrarySubscreens
import com.application.podcasts.main.home.podcasts.ui.subscreen.PodcastsSubscreen
import com.application.podcasts.main.library.ui.subscreen.LibrarySubscreen

fun NavGraphBuilder.libraryImpl() {

    composable<LibrarySubscreens.Library>(

        enterTransition = { EnterTransition.None},

        exitTransition = { ExitTransition.None},

        content = { LibrarySubscreen() }
    )
}