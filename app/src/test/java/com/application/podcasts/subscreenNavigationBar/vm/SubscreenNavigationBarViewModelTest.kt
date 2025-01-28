package com.application.podcasts.subscreenNavigationBar.vm

import androidx.navigation.NavBackStackEntry
import app.cash.turbine.test
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.CurrentSubscreen
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarErrorMessages
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import com.application.testHelpers.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class SubscreenNavigationBarViewModelTest {

    private lateinit var subscreenNavigationBarViewModel: SubscreenNavigationBarViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {

        val currentBackStackEntryFlow = flow<NavBackStackEntry> {

//          1. Home -> Podcasts
            emit(TestHelpingObject.subscreenPodcasts)
            delay(400)

//          2. Explore -> Explore
            emit(TestHelpingObject.subscreenExplore)
            delay(1000)

//          3: Account -> Account
            emit(TestHelpingObject.subscreenAccount)
            delay(2000)

//          4: Library -> Library
            emit(TestHelpingObject.subscreenLibrary)
            delay(5000)

//          5: Wrong route
            emit(TestHelpingObject.wrongRoute)
            delay(150)

//          6. Home -> Podcasts
            emit(TestHelpingObject.subscreenPodcasts)
            delay(400)

//          7. Home -> HabitTracker
            emit(TestHelpingObject.subscreenHabitTracker)
            delay(400)

//          8. Wrong subscreen
            emit(TestHelpingObject.wrongSubscreen)
            delay(400)

//          9. Wrong route and subscreen
            emit(TestHelpingObject.wrongRouteAndSubscreen)
            delay(400)
        }

        subscreenNavigationBarViewModel = SubscreenNavigationBarViewModel(
            currentBackStackEntryFlow = currentBackStackEntryFlow
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Navigating between screens and subscreens works as intended, errors are handled properly`() = runTest(StandardTestDispatcher()) {

        subscreenNavigationBarViewModel.viewState.test {

//          1. Home -> Podcasts
            advanceUntilIdle()
            assertEquals(TestHelpingObject.podcastsViewState, awaitItem())

//          2. Explore -> Explore
            advanceUntilIdle()
            assertEquals(TestHelpingObject.exploreViewState, awaitItem())

//          3: Account -> Account
            advanceUntilIdle()
            assertEquals(TestHelpingObject.accountViewState, awaitItem())

//          4: Library -> Library
            advanceUntilIdle()
            assertEquals(TestHelpingObject.libraryViewState, awaitItem())

//          5: Wrong route
            advanceUntilIdle()
            assertEquals(TestHelpingObject.wrongRouteViewState, awaitItem())

//          6. Home -> Podcasts
            advanceUntilIdle()
            assertEquals(TestHelpingObject.podcastsViewState, awaitItem())

//          7. Home -> HabitTracker
            advanceUntilIdle()
            assertEquals(TestHelpingObject.habitTrackerViewState, awaitItem())

//          8. Wrong subscreen
            advanceUntilIdle()
            assertEquals(TestHelpingObject.wrongSubscreenViewState, awaitItem())

//          9. Wrong route and subscreen
            advanceUntilIdle()
            assertEquals(TestHelpingObject.wrongRouteAndSubscreenViewState, awaitItem())

            cancelAndIgnoreRemainingEvents()
        }
    }
}

private object TestHelpingObject {

//  Home
    private const val PODCASTS_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteHome.PodcastsSubscreen"
    val subscreenPodcasts = mockk<NavBackStackEntry>(relaxed = true)
    val podcastsViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.HomeScreen,
        currentSubscreen = CurrentSubscreen.PodcastsSubscreen,
        causeOfError = null
    )

    private const val HABIT_TRACKER_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteHome.HabitTrackerSubscreen"
    val subscreenHabitTracker = mockk<NavBackStackEntry>(relaxed = true)
    val habitTrackerViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.HomeScreen,
        currentSubscreen = CurrentSubscreen.HabitTrackerSubscreen,
        causeOfError = null
    )

//  Explore
    private const val EXPLORE_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.ExploreSubscreen"
    val subscreenExplore = mockk<NavBackStackEntry>(relaxed = true)
    val exploreViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.ExploreSubscreen,
        causeOfError = null
    )

    private const val SEARCH_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SearchSubscreen"
    val subscreenSearch = mockk<NavBackStackEntry>(relaxed = true)
    val searchViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SearchSubscreen,
        causeOfError = null
    )

    private const val SELECT_LANGUAGE_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SelectLanguageSubscreen"
    val subscreenSelectLanguage = mockk<NavBackStackEntry>(relaxed = true)
    val selectLanguageViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SelectLanguageSubscreen,
        causeOfError = null
    )

    private const val SELECT_LANGUAGE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.FilterSubscreen"
    val subscreenFilter = mockk<NavBackStackEntry>(relaxed = true)
    val filterViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.ExploreScreen,
        currentSubscreen = CurrentSubscreen.SelectLanguageSubscreen,
        causeOfError = null
    )

//  Account
    private const val ACCOUNT_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteAccount.AccountSubscreen"
    val subscreenAccount = mockk<NavBackStackEntry>(relaxed = true)
    val accountViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.AccountScreen,
        currentSubscreen = CurrentSubscreen.AccountSubscreen,
        causeOfError = null
    )

//  Library
    private const val LIBRARY_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteLibrary.LibrarySubscreen"
    val subscreenLibrary = mockk<NavBackStackEntry>(relaxed = true)
    val libraryViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.LibraryScreen,
        currentSubscreen = CurrentSubscreen.LibrarySubscreen,
        causeOfError = null
    )

//  Wrong route
    private const val WRONG_ROUTE = "com.application.podcasts.constants.navigation.Navigation.WrongRoute.LibrarySubscreen"
    val wrongRoute = mockk<NavBackStackEntry>(relaxed = true)
    val wrongRouteViewState = SubscreenNavigationBarViewState(
        currentScreen = null,
        currentSubscreen = CurrentSubscreen.LibrarySubscreen,
        causeOfError = SubscreenNavigationBarErrorMessages.CURRENT_SCREEN_IS_NULL
    )

//  Wrong subscreen
    private const val WRONG_SUBSCREEN = "com.application.podcasts.constants.navigation.Navigation.RouteLibrary.WrongSubscreen"
    val wrongSubscreen = mockk<NavBackStackEntry>(relaxed = true)
    val wrongSubscreenViewState = SubscreenNavigationBarViewState(
        currentScreen = CurrentScreen.LibraryScreen,
        currentSubscreen = null,
        causeOfError = SubscreenNavigationBarErrorMessages.CURRENT_SUBSCREEN_IS_NULL
    )

//  Wrong screen and subscreen
    private const val WRONG_SCREEN_AND_SUBSCREEN = "com.application.podcasts.constants.navigation.Navigation.WrongRoute.WrongSubscreen"
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