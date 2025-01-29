package com.application.podcasts.subscreenNavigationBar.vm

import androidx.navigation.NavBackStackEntry
import app.cash.turbine.test
import com.application.testHelpers.MainDispatcherRule
import com.application.testHelpers.MockedNavigation
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
            emit(MockedNavigation.subscreenPodcasts)
            delay(400)

//          2. Explore -> Explore
            emit(MockedNavigation.subscreenExplore)
            delay(1000)

//          3: Account -> Account
            emit(MockedNavigation.subscreenAccount)
            delay(2000)

//          4: Library -> Library
            emit(MockedNavigation.subscreenLibrary)
            delay(5000)

//          5: Wrong route
            emit(MockedNavigation.wrongRoute)
            delay(150)

//          6. Home -> Podcasts
            emit(MockedNavigation.subscreenPodcasts)
            delay(400)

//          7. Home -> HabitTracker
            emit(MockedNavigation.subscreenHabitTracker)
            delay(400)

//          8. Wrong subscreen
            emit(MockedNavigation.wrongSubscreen)
            delay(400)

//          9. Wrong route and subscreen
            emit(MockedNavigation.wrongRouteAndSubscreen)
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
            assertEquals(MockedNavigation.podcastsViewState, awaitItem())

//          2. Explore -> Explore
            advanceUntilIdle()
            assertEquals(MockedNavigation.exploreViewState, awaitItem())

//          3: Account -> Account
            advanceUntilIdle()
            assertEquals(MockedNavigation.accountViewState, awaitItem())

//          4: Library -> Library
            advanceUntilIdle()
            assertEquals(MockedNavigation.libraryViewState, awaitItem())

//          5: Wrong route
            advanceUntilIdle()
            assertEquals(MockedNavigation.wrongRouteViewState, awaitItem())

//          6. Home -> Podcasts
            advanceUntilIdle()
            assertEquals(MockedNavigation.podcastsViewState, awaitItem())

//          7. Home -> HabitTracker
            advanceUntilIdle()
            assertEquals(MockedNavigation.habitTrackerViewState, awaitItem())

//          8. Wrong subscreen
            advanceUntilIdle()
            assertEquals(MockedNavigation.wrongSubscreenViewState, awaitItem())

//          9. Wrong route and subscreen
            advanceUntilIdle()
            assertEquals(MockedNavigation.wrongRouteAndSubscreenViewState, awaitItem())

            cancelAndIgnoreRemainingEvents()
        }
    }
}