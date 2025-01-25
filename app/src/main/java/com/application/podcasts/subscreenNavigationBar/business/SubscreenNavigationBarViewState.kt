package com.application.podcasts.subscreenNavigationBar.business

import com.application.podcasts.constants.navigation.CurrentScreen
import com.application.podcasts.constants.navigation.CurrentSubscreen

data class SubscreenNavigationBarViewState(
    var currentScreen: CurrentScreen? = CurrentScreen.Home, // set appropriate bar
    var currentSubscreen: CurrentSubscreen? = CurrentSubscreen.Podcasts, // when a button matches with this value, it will change the color
    var causeOfError: String? = null // in case an error occurs, display the cause
)