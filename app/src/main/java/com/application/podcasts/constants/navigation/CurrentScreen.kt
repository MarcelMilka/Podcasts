package com.application.podcasts.constants.navigation

enum class CurrentScreen {
    ExploreScreen,
    HomeScreen,
    LibraryScreen,
    AccountScreen
}

fun String.convertToCurrentScreen(): CurrentScreen? =
    when(this) {

//      Explore:
        Navigation.RouteExplore.SearchSubscreen::class.simpleName -> CurrentScreen.ExploreScreen
        Navigation.RouteExplore.ExploreSubscreen::class.simpleName -> CurrentScreen.ExploreScreen
        Navigation.RouteExplore.SelectLanguageSubscreen::class.simpleName -> CurrentScreen.ExploreScreen
        Navigation.RouteExplore.FilterSubscreen::class.simpleName -> CurrentScreen.ExploreScreen

//      Home:
        Navigation.RouteHome.PodcastsSubscreen::class.simpleName -> CurrentScreen.HomeScreen
        Navigation.RouteHome.HabitTrackerSubscreen::class.simpleName -> CurrentScreen.HomeScreen

//      Library:
        Navigation.RouteLibrary.LibrarySubscreen::class.simpleName -> CurrentScreen.LibraryScreen

//      Account:
        Navigation.RouteAccount.AccountSubscreen::class.simpleName -> CurrentScreen.AccountScreen
        else -> null
    }