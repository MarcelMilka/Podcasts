package com.application.podcasts.constants.navigation

enum class CurrentScreen {
    Explore,
    Home,
    Library
}

fun String.convertToCurrentScreen(): CurrentScreen? =
    when(this) {

        "Explore" -> CurrentScreen.Explore
        "Podcasts" -> CurrentScreen.Home
        "HabitTracker" -> CurrentScreen.Home
        "Library" -> CurrentScreen.Library
        else -> null
    }