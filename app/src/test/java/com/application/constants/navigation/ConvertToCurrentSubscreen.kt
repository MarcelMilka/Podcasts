package com.application.constants.navigation

import com.application.podcasts.constants.navigation.CurrentSubscreen
import com.application.podcasts.constants.navigation.convertToCurrentSubscreen
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ConvertToCurrentSubscreen {

    @Test
    fun `the extension function convertToCurrentSubscreen properly turns a string into CurrentSubscreen enum or null`() {

        assertEquals(CurrentSubscreen.SearchSubscreen, "SearchSubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.ExploreSubscreen, "ExploreSubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.FilterSubscreen, "FilterSubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.PodcastsSubscreen, "PodcastsSubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.HabitTrackerSubscreen, "HabitTrackerSubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.LibrarySubscreen, "LibrarySubscreen".convertToCurrentSubscreen())
        assertEquals(CurrentSubscreen.AccountSubscreen, "AccountSubscreen".convertToCurrentSubscreen())

        assertNull("NonExistentSubscreen".convertToCurrentSubscreen())
        assertNull("".convertToCurrentSubscreen())
        assertNull("12345".convertToCurrentSubscreen())
        assertNull("searchsubscreen".convertToCurrentSubscreen())
    }
}