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
        Navigation.RouteExplore.Search::class.simpleName -> CurrentScreen.Explore
        Navigation.RouteExplore.Explore::class.simpleName -> CurrentScreen.Explore
        Navigation.RouteExplore.SelectLanguage::class.simpleName -> CurrentScreen.Explore
        Navigation.RouteExplore.Filter::class.simpleName -> CurrentScreen.Explore

//      Home:
        Navigation.RouteHome.Podcasts::class.simpleName -> CurrentScreen.Home
        Navigation.RouteHome.HabitTracker::class.simpleName -> CurrentScreen.Home

//      Library:
        Navigation.RouteLibrary.Library::class.simpleName -> CurrentScreen.Library

//      Account:
        Navigation.Account::class.simpleName -> CurrentScreen.Account
        else -> null
    }