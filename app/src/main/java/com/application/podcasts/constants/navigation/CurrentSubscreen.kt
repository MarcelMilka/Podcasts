package com.application.podcasts.constants.navigation

sealed class CurrentSubscreen {
//  Explore:
    object Search: CurrentSubscreen()
    object Explore: CurrentSubscreen()
    object SelectLanguage: CurrentSubscreen()
    object ExploreByLanguage: CurrentSubscreen()
    object Filter: CurrentSubscreen()
    object ExploreByGenre: CurrentSubscreen()

//  Home:
    object Podcasts: CurrentSubscreen()
    object HabitTracker: CurrentSubscreen()
}

fun String.convertToCurrentSubscreen(): CurrentSubscreen? =
    when(this) {

//      Explore:
        "Search" -> CurrentSubscreen.Search
        "Explore" -> CurrentSubscreen.Explore
        "SelectLanguage" -> CurrentSubscreen.SelectLanguage
        "ExploreByLanguage" -> CurrentSubscreen.ExploreByLanguage
        "Filter" -> CurrentSubscreen.Filter
        "ExploreByGenre" -> CurrentSubscreen.ExploreByGenre

//      Home:
        "Podcasts" -> CurrentSubscreen.Podcasts
        "HabitTracker" -> CurrentSubscreen.HabitTracker

        else -> null
    }