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
        Navigation.RouteExplore.Search::class.simpleName -> CurrentSubscreen.Search
        Navigation.RouteExplore.Explore::class.simpleName -> CurrentSubscreen.Explore
        Navigation.RouteExplore.SelectLanguage::class.simpleName -> CurrentSubscreen.SelectLanguage
        Navigation.RouteExplore.ExploreByLanguage::class.simpleName -> CurrentSubscreen.ExploreByLanguage
        Navigation.RouteExplore.Filter::class.simpleName -> CurrentSubscreen.Filter
        Navigation.RouteExplore.ExploreByGenre::class.simpleName -> CurrentSubscreen.ExploreByGenre

//      Home:
        Navigation.RouteHome.Podcasts::class.simpleName -> CurrentSubscreen.Podcasts
        Navigation.RouteHome.HabitTracker::class.simpleName -> CurrentSubscreen.HabitTracker

        else -> null
    }