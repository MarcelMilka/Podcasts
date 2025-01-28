package com.application.podcasts.subscreenNavigationBar.vm

import androidx.navigation.NavBackStackEntry
import app.cash.turbine.test
import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.CurrentSubscreen
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

//          1.
            emit(TestHelpingObject.subscreenPodcasts)
            delay(400)

//          2.
            emit(TestHelpingObject.subscreenExplore)
            delay(1000)

//          3:
            emit(TestHelpingObject.subscreenAccount)
            delay(2000)

//          4:
            emit(TestHelpingObject.subscreenLibrary)
            delay(5000)
        }

        subscreenNavigationBarViewModel = SubscreenNavigationBarViewModel(
            currentBackStackEntryFlow = currentBackStackEntryFlow
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `Navigating between screens works as intended`() = runTest(StandardTestDispatcher()) {

        subscreenNavigationBarViewModel.viewState.test {

//          1.
            advanceUntilIdle()
            assertEquals(TestHelpingObject.podcastsViewState, awaitItem())

//          2.
            advanceUntilIdle()
            assertEquals(TestHelpingObject.exploreViewState, awaitItem())

//          3.
            advanceUntilIdle()
            assertEquals(TestHelpingObject.accountViewState, awaitItem())

//          4.
            advanceUntilIdle()
            assertEquals(TestHelpingObject.libraryViewState, awaitItem())

            cancelAndIgnoreRemainingEvents()
        }
    }
}

private object TestHelpingObject {

//    private const val SEARCH_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SearchSubscreen"
//    private const val SELECT_LANGUAGE_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SelectLanguageSubscreen"
//    private const val FILTER_ROUTE = "com.application.podcasts.constants.navigation.Navigation.RouteExplore.SelectLanguageSubscreen"

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

    init {

        coEvery { subscreenPodcasts.destination.route } returns PODCASTS_ROUTE

        coEvery { subscreenHabitTracker.destination.route } returns HABIT_TRACKER_ROUTE

        coEvery { subscreenExplore.destination.route } returns EXPLORE_ROUTE

        coEvery { subscreenAccount.destination.route } returns ACCOUNT_ROUTE

        coEvery { subscreenLibrary.destination.route } returns LIBRARY_ROUTE
    }
}