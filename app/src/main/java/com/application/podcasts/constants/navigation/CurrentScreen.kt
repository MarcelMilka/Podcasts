package com.application.podcasts.constants.navigation

enum class CurrentScreen {
    Explore,
    Home,
    Library,
    Account
}

fun String.convertToCurrentScreen(): CurrentScreen? =
    when(this) {
        "Search" -> CurrentScreen.Explore
        "Explore" -> CurrentScreen.Explore
        "SelectLanguage" -> CurrentScreen.Explore
        "Filter" -> CurrentScreen.Explore
        "Podcasts" -> CurrentScreen.Home
        "HabitTracker" -> CurrentScreen.Home
        "Library" -> CurrentScreen.Library
        "Account" -> CurrentScreen.Account
        else -> null
    }