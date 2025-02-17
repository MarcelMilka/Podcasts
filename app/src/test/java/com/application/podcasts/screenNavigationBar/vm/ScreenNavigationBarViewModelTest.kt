package com.application.podcasts.screenNavigationBar.vm

import androidx.navigation.NavBackStackEntry
import app.cash.turbine.test
import com.application.podcasts.constants.navigation.CurrentScreen
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
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

@RunWith(JUnit4::class)
class ScreenNavigationBarViewModelTest {

    private lateinit var screenNavigationBarViewModel: ScreenNavigationBarViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUpToTestDefaultValue() {

        val currentBackStackEntryFlow = flow<NavBackStackEntry> {}

        screenNavigationBarViewModel = ScreenNavigationBarViewModel(
            currentBackStackEntryFlow = currentBackStackEntryFlow
        )
    }

    fun setUp() {

        val currentBackStackEntryFlow = flow<NavBackStackEntry> {

            delay(1000)

//          1. Wrong route (omitted)
            emit(MockedNavigation.wrongRoute)
            delay(400)

//          2. Account
            emit(MockedNavigation.subscreenAccount)
            delay(400)

//          3. Explore
            emit(MockedNavigation.subscreenExplore)
            delay(400)
//
//          4. Wrong route and subscreen (omitted)
            emit(MockedNavigation.wrongRouteAndSubscreen)
            delay(400)

//          5. Library
            emit(MockedNavigation.subscreenLibrary)
            delay(400)

//          6. Home
            emit(MockedNavigation.subscreenPodcasts)
            delay(400)
        }

        screenNavigationBarViewModel = ScreenNavigationBarViewModel(
            currentBackStackEntryFlow = currentBackStackEntryFlow
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `initial viewState is HomeScreen`() = runTest(StandardTestDispatcher()) {

        screenNavigationBarViewModel.viewState.test {

            assertEquals(CurrentScreen.HomeScreen, awaitItem())

            cancelAndIgnoreRemainingEvents()
        }
    }
}