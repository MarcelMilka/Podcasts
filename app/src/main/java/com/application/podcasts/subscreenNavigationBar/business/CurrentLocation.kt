package com.application.podcasts.subscreenNavigationBar.business

import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.CurrentSubscreen

data class CurrentLocation(
    val screen: CurrentScreen? = null,
    val subscreen: CurrentSubscreen? = null
)