package com.application.podcasts.subscreenNavigationBar.vm

import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import kotlinx.coroutines.flow.Flow

class SubscreenNavigationBarViewModel(
    private val backStackEntry: Flow<NavBackStackEntry>
): ViewModel()