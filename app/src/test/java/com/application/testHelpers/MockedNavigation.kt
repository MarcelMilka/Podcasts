package com.application.testHelpers

import androidx.navigation.NavBackStackEntry
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.CurrentSubscreen
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarErrorMessages
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import io.mockk.coEvery
import io.mockk.mockk

object MockedNavigation {

 //  Home
    const val PODCASTS_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteHome.PodcastsSubscreen"
    val subscreenPodcasts = mockk<NavBackStackEntry>(relaxed = true)
    val podcastsViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.HomeScreen,
        currentSubscreen = CurrentSubscreen.PodcastsSubscreen,
        causeOfError = null
    )

    const val HABIT_TRACKER_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteHome.HabitTrackerSubscreen"
    val subscreenHabitTracker = mockk<NavBackStackEntry>(relaxed = true)
    val habitTrackerViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.HomeScreen,
        currentSubscreen = CurrentSubscreen.HabitTrackerSubscreen,
        causeOfError = null
    )

//  Explore
    const val EXPLORE_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.ExploreSubscreen"
    val subscreenExplore = mockk<NavBackStackEntry>(relaxed = true)
    val exploreViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.ExploreSubscreen,
        causeOfError = null
    )

    const val SEARCH_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SearchSubscreen"
    val subscreenSearch = mockk<NavBackStackEntry>(relaxed = true)
    val searchViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SearchSubscreen,
        causeOfError = null
    )

    const val SELECT_LANGUAGE_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SelectLanguageSubscreen"
    val subscreenSelectLanguage = mockk<NavBackStackEntry>(relaxed = true)
    val selectLanguageViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SelectLanguageSubscreen,
        causeOfError = null
    )

    const val SELECT_LANGUAGE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.FilterSubscreen"
    val subscreenFilter = mockk<NavBackStackEntry>(relaxed = true)
    val filterViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SelectLanguageSubscreen,
        causeOfError = null
    )

//  Account
    const val ACCOUNT_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteAccount.AccountSubscreen"
    val subscreenAccount = mockk<NavBackStackEntry>(relaxed = true)
    val accountViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.AccountScreen,
        currentSubscreen = CurrentSubscreen.AccountSubscreen,
        causeOfError = null
    )

//  Library
    const val LIBRARY_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteLibrary.LibrarySubscreen"
    val subscreenLibrary = mockk<NavBackStackEntry>(relaxed = true)
    val libraryViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.LibraryScreen,
        currentSubscreen = CurrentSubscreen.LibrarySubscreen,
        causeOfError = null
    )

//  Wrong route
    const val WRONG_ROUTE = "com.application.podcasts.constants.navigation.Navigation.WrongRoute.LibrarySubscreen"
    val wrongRoute = mockk<NavBackStackEntry>(relaxed = true)
    val wrongRouteViewState = SubscreenNavigationBarViewState(
        currentScreen = null,
        currentSubscreen = CurrentSubscreen.LibrarySubscreen,
        causeOfError = SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_IS_NULL
    )

//  Wrong subscreen
    const val WRONG_SUBSCREEN = "com.application.podcasts.constants.navigation.Navigation.RouteLibrary.WrongSubscreen"
    val wrongSubscreen = mockk<NavBackStackEntry>(relaxed = true)
    val wrongSubscreenViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.LibraryScreen,
        currentSubscreen = null,
        causeOfError = SubscreenNavigationBarErrorMessages.CURRENT_SUBSCREEN_IS_NULL
    )

//  Wrong screen and subscreen
    const val WRONG_SCREEN_AND_SUBSCREEN = "com.application.podcasts.constants.navigation.Navigation.WrongRoute.WrongSubscreen"
    val wrongRouteAndSubscreen = mockk<NavBackStackEntry>(relaxed = true)
    val wrongRouteAndSubscreenViewState = SubscreenNavigationBarViewState(
        currentScreen = null,
        currentSubscreen = null,
        causeOfError = SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_AND_SUBSCREEN_ARE_NULL
    )

    init {

        coEvery { subscreenPodcasts.destination.route } returns PODCASTS_ROUTE

        coEvery { subscreenHabitTracker.destination.route } returns HABIT_TRACKER_ROUTE

        coEvery { subscreenExplore.destination.route } returns EXPLORE_ROUTE

        coEvery { subscreenAccount.destination.route } returns ACCOUNT_ROUTE

        coEvery { subscreenLibrary.destination.route } returns LIBRARY_ROUTE

        coEvery { wrongRoute.destination.route } returns WRONG_ROUTE

        coEvery { wrongSubscreen.destination.route } returns WRONG_SUBSCREEN

        coEvery { wrongRouteAndSubscreen.destination.route } returns WRONG_SCREEN_AND_SUBSCREEN
    }
}