package com.application.podcasts.constants.navigation

sealed class CurrentSubscreen {
//  Explore:
    object SearchSubscreen: CurrentSubscreen()
    object ExploreSubscreen: CurrentSubscreen()
    object FilterSubscreen: CurrentSubscreen()

//  Home:
    object PodcastsSubscreen: CurrentSubscreen()
    object HabitTrackerSubscreen: CurrentSubscreen()

//  Account:
    object LibrarySubscreen: CurrentSubscreen()

//  Account:
    object AccountSubscreen: CurrentSubscreen()
}

fun String.convertToCurrentSubscreen(): CurrentSubscreen? =
    when(this) {

//      Explore:
        Navigation.RouteExplore.SearchSubscreen::class.simpleName -> CurrentSubscreen.SearchSubscreen
        Navigation.RouteExplore.ExploreSubscreen::class.simpleName -> CurrentSubscreen.ExploreSubscreen
        Navigation.RouteExplore.FilterSubscreen::class.simpleName -> CurrentSubscreen.FilterSubscreen

//      Home:
        Navigation.RouteHome.PodcastsSubscreen::class.simpleName -> CurrentSubscreen.PodcastsSubscreen
        Navigation.RouteHome.HabitTrackerSubscreen::class.simpleName -> CurrentSubscreen.HabitTrackerSubscreen

//      Library
        Navigation.RouteLibrary.LibrarySubscreen::class.simpleName -> CurrentSubscreen.LibrarySubscreen

//      Account
        Navigation.RouteAccount.AccountSubscreen::class.simpleName -> CurrentSubscreen.AccountSubscreen

        else -> null
    }