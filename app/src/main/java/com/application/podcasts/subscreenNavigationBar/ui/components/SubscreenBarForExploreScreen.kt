package com.application.podcasts.subscreenNavigationBar.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.constants.navigation.CurrentSubscreen
import com.application.podcasts.subscreenNavigationBar.business.SubscreenNavigationBarViewState
import com.application.podcasts.subscreenNavigationBar.ui.elements.SubscreenNavigationBarButton
import com.application.podcasts.subscreenNavigationBar.ui.elements.SubscreenNavigationBarIconButton

@Composable
fun LazyItemScope.SubscreenBarForExploreScreen(
    uiState: SubscreenNavigationBarViewState,
    onSearch: () -> Unit,
    onExplore: () -> Unit,
    onFilter: () -> Unit
) {

    SubscreenNavigationBarIconButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.SearchSubscreen,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.SearchSubscreen,
        icon = Icons.Rounded.Search,
        testTag = "IconButtonSearch",
        onClick = {

            onSearch()
        },
    )

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.ExploreSubscreen,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.ExploreSubscreen,
        content = "Explore",
        testTag = "Explore",
        onClick = {

            onExplore()
        }
    )

    Spacer(Modifier.width(5.dp))

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.FilterSubscreen,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.FilterSubscreen,
        content = "Filter",
        testTag = "Filter",
        onClick = {

            onFilter()
        }
    )
}