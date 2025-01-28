package com.application.podcasts.constants.navigation

import kotlinx.serialization.Serializable

sealed class Navigation {

    @Serializable
    sealed class RouteExplore(): Navigation() {

        @Serializable
        object ExploreScreen: RouteExplore()

        @Serializable
        object SearchSubscreen: RouteExplore()

        @Serializable
        object ExploreSubscreen: RouteExplore()

        @Serializable
        object SelectLanguageSubscreen: RouteExplore()

        @Serializable
        object ExploreByLanguageSubscreen: RouteExplore()

        @Serializable
        object FilterSubscreen: RouteExplore()

        @Serializable
        object ExploreByGenreSubscreen: RouteExplore()
    }

    @Serializable
    sealed class RouteHome: Navigation() {

        @Serializable
        object HomeScreen: RouteHome()

        @Serializable
        object PodcastsSubscreen: RouteHome()

        @Serializable
        object HabitTrackerSubscreen: RouteHome()
    }

    @Serializable
    sealed class RouteLibrary: Navigation() {

        @Serializable
        object LibraryScreen: RouteLibrary()

        @Serializable
        object LibrarySubscreen: RouteLibrary()
    }

    @Serializable
    sealed class RouteAccount: Navigation() {

        @Serializable
        object AccountScreen: RouteAccount()

        @Serializable
        object AccountSubscreen: RouteAccount()
    }
}