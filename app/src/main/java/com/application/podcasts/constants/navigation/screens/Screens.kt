package com.application.podcasts.constants.navigation.screens

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable object Explore: Screens()

    @Serializable object Home: Screens()

    @Serializable object Library: Screens()
}