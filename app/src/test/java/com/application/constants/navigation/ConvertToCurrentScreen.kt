package com.application.constants.navigation

import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.convertToCurrentScreen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ConvertToCurrentScreen {

    @Test
    fun `the extension function convertToCurrentScreen properly turns a string into CurrentScreen enum or null`() {

        assertEquals("RouteHome".convertToCurrentScreen(), CurrentScreen.HomeScreen)
        assertEquals("RouteExplore".convertToCurrentScreen(), CurrentScreen.ExploreScreen)
        assertEquals("RouteAccount".convertToCurrentScreen(), CurrentScreen.AccountScreen)
        assertEquals("RouteLibrary".convertToCurrentScreen(), CurrentScreen.LibraryScreen)

        assertNull("nonExistentRouteHome".convertToCurrentScreen())
        assertNull("".convertToCurrentScreen())
        assertNull("12345".convertToCurrentScreen())
        assertNull("routehome".convertToCurrentScreen())
    }
}