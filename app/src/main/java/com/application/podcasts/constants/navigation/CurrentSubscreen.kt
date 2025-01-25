package com.application.podcasts.constants.navigation

sealed class CurrentSubscreen {
    object Podcasts: CurrentSubscreen()
    object HabitTracker: CurrentSubscreen()
    object Explore: CurrentSubscreen()
}

fun String.convertToCurrentSubscreen(): CurrentSubscreen? =
    when(this) {

        "Podcasts" -> CurrentSubscreen.Podcasts
        "HabitTracker" -> CurrentSubscreen.HabitTracker
        "Explore" -> CurrentSubscreen.Explore
        else -> null
    }