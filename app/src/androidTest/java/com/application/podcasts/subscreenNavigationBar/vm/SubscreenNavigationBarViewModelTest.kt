package com.application.podcasts.subscreenNavigationBar.vm

import androidx.navigation.NavBackStackEntry
import com.application.podcasts.testHelpingObjects.MockedNavBackStackEntryRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import org.junit.Before

class SubscreenNavigationBarViewModelTest

private object TestHelpingObject {

    val mockedNavBackStackEntry = flow<String> {

        this.emit(MockedNavBackStackEntryRoutes.EXPLORE)
    }
}