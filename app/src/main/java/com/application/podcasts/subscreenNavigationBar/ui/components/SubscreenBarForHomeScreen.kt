package com.application.podcasts.subscreenNavigationBar.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.constants.navigation.CurrentSubscreen
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import com.application.podcasts.subscreenNavigationBar.ui.elements.SubscreenNavigationBarButton

@Composable
fun LazyItemScope.SubscreenBarForHomeScreen(
    uiState: SubscreenNavigationBarViewState,
    onNavigateToPodcasts: () -> Unit,
    onNavigateToHabitTracker: () -> Unit
) {

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.PodcastsSubscreen,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.PodcastsSubscreen,
        content = "Podcasts",
        testTag = "Podcasts",
        onClick = {

            onNavigateToPodcasts()
        }
    )

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.HabitTrackerSubscreen,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.HabitTrackerSubscreen,
        content = "Habit tracker",
        testTag = "Habit tracker",
        onClick = {

            onNavigateToHabitTracker()
        }
    )
}