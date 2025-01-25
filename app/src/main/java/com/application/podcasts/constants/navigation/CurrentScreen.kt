package com.application.podcasts.constants.navigation

enum class CurrentScreen {
    Explore,
    Home,
    Library,
    Account
}

fun String.convertToCurrentScreen(): CurrentScreen? =
    when(this) {

//      Explore:
        "Search" -> CurrentScreen.Explore
        "Explore" -> CurrentScreen.Explore
        "SelectLanguage" -> CurrentScreen.Explore
        "Filter" -> CurrentScreen.Explore
        "Library" -> CurrentScreen.Library
        "Account" -> CurrentScreen.Account

//      Home:
        "Podcasts" -> CurrentScreen.Home
        "HabitTracker" -> CurrentScreen.Home

        else -> null
    }