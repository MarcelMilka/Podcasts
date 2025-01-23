package com.application.podcasts.constants.navigation.subscreens

import kotlinx.serialization.Serializable

sealed class HomeSubscreens {

    @Serializable object Podcasts: HomeSubscreens()

    @Serializable object HabitTracker: HomeSubscreens()
}