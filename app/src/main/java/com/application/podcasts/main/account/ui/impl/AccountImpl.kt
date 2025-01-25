package com.application.podcasts.main.account.ui.impl

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.account.ui.subscreen.AccountScreen

fun NavGraphBuilder.accountImpl() {

    composable<Navigation.Account>(

        enterTransition = {EnterTransition.None},

        exitTransition = {ExitTransition.None},

        content = { AccountScreen() }
    )
}