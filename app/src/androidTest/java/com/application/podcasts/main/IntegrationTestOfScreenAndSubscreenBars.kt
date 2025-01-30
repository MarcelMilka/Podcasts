package com.application.podcasts.main

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class IntegrationTestOfScreenAndSubscreenBars {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigatingBetweenScreensAndSubscreensWorksAsIntended() = runBlocking {

//      Home(podcasts) is set by default
        buttonExploreScreen.assertIsEnabled()
        buttonHomeScreen.assertIsNotEnabled()
        buttonLibraryScreen.assertIsEnabled()

//      Navigate to Home(habit tracker)
        buttonHabitTracker.performClick()
        composeTestRule.awaitIdle()

        buttonHabitTracker.assertIsNotEnabled()
        buttonPodcasts.assertIsEnabled()
        textInHabitTracker.assertIsDisplayed()

//      Navigate back with system back button to Home(podcasts)
        composeTestRule.activity.runOnUiThread {
            composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.awaitIdle()

        buttonHabitTracker.assertIsEnabled()
        buttonPodcasts.assertIsNotEnabled()
        textInPodcasts.assertIsDisplayed()

//      Navigate to Account(account)
        buttonAccount.performClick()
        composeTestRule.awaitIdle()

        buttonExploreScreen.assertIsEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInAccount.assertIsDisplayed()

//      Navigate back with system back button to Home(podcasts)
        composeTestRule.activity.runOnUiThread {
            composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.awaitIdle()

        buttonExploreScreen.assertIsEnabled()
        buttonHomeScreen.assertIsNotEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInPodcasts.assertIsDisplayed()

//      Navigate to Account(account)
        buttonAccount.performClick()
        composeTestRule.awaitIdle()

        buttonExploreScreen.assertIsEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInAccount.assertIsDisplayed()

//      Navigate to Explore(explore)
        buttonExploreScreen.performClick()
        composeTestRule.awaitIdle()

        buttonExploreScreen.assertIsNotEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInExplore.assertIsDisplayed()

//      Navigate to Explore(search)
        buttonSearch.performClick()
        composeTestRule.awaitIdle()

        textInSearch.assertIsDisplayed()

//      Navigate back with system back button to Explore(explore)
        composeTestRule.activity.runOnUiThread {
            composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        }

        buttonExploreScreen.assertIsNotEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInExplore.assertIsDisplayed()

//      Navigate to Library(library)
        buttonLibraryScreen.performClick()
        composeTestRule.awaitIdle()

        buttonExploreScreen.assertIsEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsNotEnabled()

        textInLibraryScreen.assertIsDisplayed()

//      Navigate back with system back button to Explore(explore)
        composeTestRule.activity.runOnUiThread {
            composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        }

        buttonExploreScreen.assertIsNotEnabled()
        buttonHomeScreen.assertIsEnabled()
        buttonLibraryScreen.assertIsEnabled()

        textInExplore.assertIsDisplayed()

//      Navigate to Explore(explore by language)
        buttonExploreByLanguage.performClick()
        composeTestRule.awaitIdle()

        textInExploreByLanguage.assertIsDisplayed()

//      Scroll upper navigation bar to the right
        lazyRowOfSubscreenNavigationBar.performScrollToNode(hasText("Filter"))
        composeTestRule.awaitIdle()

//      Navigate to Explore(filter)
        buttonFilter.performClick()
        composeTestRule.awaitIdle()

        textInFilter.assertIsDisplayed()

//      Scroll upper navigation bar to the left
        lazyRowOfSubscreenNavigationBar.performScrollToNode(hasText("Explore"))
        composeTestRule.awaitIdle()

//      Navigate to Explore(explore)
        buttonExplore.performClick()
        composeTestRule.awaitIdle()

        textInExplore.assertIsDisplayed()

//      Navigate to Home(podcasts)
        buttonHomeScreen.performClick()
        composeTestRule.awaitIdle()

        assertTrue(true)
    }

    private val buttonExploreScreen = composeTestRule.onNodeWithTag("Bottom bar icon button explore")

        private val buttonSearch = composeTestRule.onNodeWithTag("IconButtonSearch")
        private val textInSearch = composeTestRule.onNodeWithText("Screen 'Explore' -> 'Search'")

        private val buttonExplore = composeTestRule.onNodeWithTag("Explore")
        private val textInExplore = composeTestRule.onNodeWithText("Screen 'Explore' -> 'Explore'")

        private val buttonExploreByLanguage = composeTestRule.onNodeWithTag("Explore")
        private val textInExploreByLanguage = composeTestRule.onNodeWithText("Screen 'Explore' -> 'Explore'")

        private val buttonFilter = composeTestRule.onNodeWithTag("Filter")
        private val textInFilter = composeTestRule.onNodeWithText("Screen 'Explore' -> 'Filter'")


    private val buttonHomeScreen = composeTestRule.onNodeWithTag("Bottom bar icon button home")

        private val buttonPodcasts = composeTestRule.onNodeWithTag("Podcasts")
        private val textInPodcasts = composeTestRule.onNodeWithText("Screen 'Home' -> 'Podcasts'")

        private val buttonHabitTracker = composeTestRule.onNodeWithTag("Habit tracker")
        private val textInHabitTracker = composeTestRule.onNodeWithText("Screen 'Home' -> 'Habit tracker'")

    private val buttonLibraryScreen = composeTestRule.onNodeWithTag("Bottom bar icon button library")
        private val textInLibraryScreen = composeTestRule.onNodeWithText("Screen 'Library' -> 'Library'")

    private val buttonAccount = composeTestRule.onNodeWithTag("IconButtonAccount")
        private val textInAccount = composeTestRule.onNodeWithText("Screen 'Account' -> 'Account'")

    private val lazyRowOfSubscreenNavigationBar = composeTestRule.onNodeWithTag("Lazy row of subscreen navigation bar")
}