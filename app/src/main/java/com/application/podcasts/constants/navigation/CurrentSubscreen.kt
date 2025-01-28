package com.application.podcasts.constants.navigation

sealed class CurrentSubscreen {
//  Explore:
    object SearchSubscreen: CurrentSubscreen()
    object ExploreSubscreen: CurrentSubscreen()
    object SelectLanguageSubscreen: CurrentSubscreen()
    object ExploreByLanguageSubscreen: CurrentSubscreen()
    object FilterSubscreen: CurrentSubscreen()
    object ExploreByGenreSubscreen: CurrentSubscreen()

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
        Navigation.RouteExplore.SelectLanguageSubscreen::class.simpleName -> CurrentSubscreen.SelectLanguageSubscreen
        Navigation.RouteExplore.ExploreByLanguageSubscreen::class.simpleName -> CurrentSubscreen.ExploreByLanguageSubscreen
        Navigation.RouteExplore.FilterSubscreen::class.simpleName -> CurrentSubscreen.FilterSubscreen
        Navigation.RouteExplore.ExploreByGenreSubscreen::class.simpleName -> CurrentSubscreen.ExploreByGenreSubscreen

//      Home:
        Navigation.RouteHome.PodcastsSubscreen::class.simpleName -> CurrentSubscreen.PodcastsSubscreen
        Navigation.RouteHome.HabitTrackerSubscreen::class.simpleName -> CurrentSubscreen.HabitTrackerSubscreen

//      Library
        Navigation.RouteLibrary.LibrarySubscreen::class.simpleName -> CurrentSubscreen.LibrarySubscreen

//      Account
        Navigation.RouteAccount.AccountSubscreen::class.simpleName -> CurrentSubscreen.AccountSubscreen

        else -> null
    }