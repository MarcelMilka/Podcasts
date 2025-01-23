package com.application.podcasts.constants.navigation.screens

enum class CurrentScreen {
    Explore,
    Home,
    Library
}

fun String.convertToEnumCurrentScreen(): CurrentScreen? =
    when(this) {

        "Explore" -> CurrentScreen.Explore
        "Podcasts" -> CurrentScreen.Home
        "HabitTracker" -> CurrentScreen.Home
        "Library" -> CurrentScreen.Library
        else -> null
    }