package com.application.podcasts.constants.navigation

enum class CurrentScreen {
    ExploreScreen,
    HomeScreen,
    LibraryScreen,
    AccountScreen
}

fun String.convertToCurrentScreen(): CurrentScreen? =
    when(this) {

        Navigation.RouteExplore::class.simpleName -> CurrentScreen.ExploreScreen
        Navigation.RouteHome::class.simpleName -> CurrentScreen.HomeScreen
        Navigation.RouteLibrary::class.simpleName -> CurrentScreen.LibraryScreen
        Navigation.RouteAccount::class.simpleName -> CurrentScreen.AccountScreen
        else -> null
    }