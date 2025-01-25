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
    onExploreByLanguage: () -> Unit,
    onFilter: () -> Unit
) {

    SubscreenNavigationBarIconButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.Search,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.Search,
        icon = Icons.Rounded.Search,
        testTag = "IconButtonSearch",
        onClick = {

            onSearch()
        },
    )

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.Explore,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.Explore,
        content = "Explore",
        onClick = {

            onExplore()
        }
    )

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.SelectLanguage,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.SelectLanguage,
        content = "Explore by language",
        onClick = {

            onExploreByLanguage()
        }
    )

    Spacer(Modifier.width(5.dp))

    SubscreenNavigationBarButton(
        isActive = uiState.currentSubscreen == CurrentSubscreen.Filter,
        isEnabled = uiState.currentSubscreen != CurrentSubscreen.Filter,
        content = "Filter",
        onClick = {

            onFilter()
        }
    )
}