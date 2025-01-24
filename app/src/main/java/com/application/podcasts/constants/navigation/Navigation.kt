package com.application.podcasts.constants.navigation

import kotlinx.serialization.Serializable

sealed class Navigation {

    @Serializable
    sealed class RouteExplore(): Navigation() {

        @Serializable
        object ExploreScreen: RouteExplore()

        @Serializable
        object Explore: RouteExplore()

        @Serializable
        object ExploreByGenre: RouteExplore()

        @Serializable
        object SelectLanguage: RouteExplore()

        @Serializable
        object ExploreByLanguage: RouteExplore()
    }

    @Serializable
    sealed class RouteHome: Navigation() {

        @Serializable
        object HomeScreen: RouteHome()

        @Serializable
        object Podcasts: RouteHome()

        @Serializable
        object HabitTracker: RouteHome()
    }

    @Serializable
    sealed class RouteLibrary: Navigation() {

        @Serializable
        object LibraryScreen: RouteLibrary()

        @Serializable
        object Library: RouteLibrary()
    }

    @Serializable
    object Account: Navigation()
}