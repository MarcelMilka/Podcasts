package com.application.podcasts.sharedUI.commonComponents.screenNavigationBar

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.application.podcasts.main.MainActivity
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class ScreenNavigationBarTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeScreenIsSetByDefault() = runBlocking {

//      Button 'Explore' is enabled, no text signifying being in 'Explore' screen is displayed.
        buttonExplore.assertIsDisplayed()
        buttonExplore.assertIsEnabled()
        textInExploreScreen.assertIsNotDisplayed()

//      Button 'Home' is not enabled, signifying being in 'Home' screen is displayed.
        buttonHome.assertIsDisplayed()
        buttonHome.assertIsNotEnabled()
        textInHomeScreen.assertIsDisplayed()

//      Button 'Library' is enabled, no text signifying being in 'Library' screen is displayed.
        buttonLibrary.assertIsDisplayed()
        buttonLibrary.assertIsEnabled()
        textInLibraryScreen.assertIsNotDisplayed()

        assertTrue(true)
    }

    @Test
    fun navigatingBetweenScreensWorksProperly() = runBlocking {

//      Navigate from 'Home' to 'Library'
        buttonLibrary.performClick()
        composeTestRule.awaitIdle()
        textInLibraryScreen.assertIsDisplayed()

//      Navigate from 'Library' to 'Home'
        buttonHome.performClick()
        composeTestRule.awaitIdle()
        textInHomeScreen.assertIsDisplayed()
        assertTrue(true)

//      Navigate from 'Home' to 'Explore'
        buttonExplore.performClick()
        composeTestRule.awaitIdle()
        textInExploreScreen.assertIsDisplayed()
        assertTrue(true)

//      Navigate from 'Explore' to 'Library'
        buttonLibrary.performClick()
        composeTestRule.awaitIdle()
        textInLibraryScreen.assertIsDisplayed()

        assertTrue(true)
    }

    @Test
    fun stateChangesProperlyWhenUserNavigatesBackUsingTheBackButton() = runBlocking {

//      Navigate from 'Home' to 'Explore'
        buttonExplore.performClick()
        composeTestRule.awaitIdle()
        textInExploreScreen.assertIsDisplayed()

//      Navigate back with built-in back button
        composeTestRule.activity.runOnUiThread {
            composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.awaitIdle()

//      Check if ScreenNavigationBar shows user is in the 'Home' screen
        buttonExplore.assertIsEnabled()
        buttonLibrary.assertIsEnabled()
        buttonHome.assertIsNotEnabled()
        textInHomeScreen.assertIsDisplayed()

        assertTrue(true)
    }

    private val buttonExplore = composeTestRule.onNodeWithTag("Bottom bar icon button explore")
    private val textInExploreScreen = composeTestRule.onNodeWithText("Screen 'Explore' -> 'Explore'")

    private val buttonHome = composeTestRule.onNodeWithTag("Bottom bar icon button home")
    private val textInHomeScreen = composeTestRule.onNodeWithText("Screen 'Home' -> 'Podcasts'")

    private val buttonLibrary = composeTestRule.onNodeWithTag("Bottom bar icon button library")
    private val textInLibraryScreen = composeTestRule.onNodeWithText("Screen 'Library'")
}