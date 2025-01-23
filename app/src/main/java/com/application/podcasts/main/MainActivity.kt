package com.application.podcasts.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.application.podcasts.constants.navigation.screens.Screens
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.main.home.habitTracker.ui.impl.habitTrackerImpl
import com.application.podcasts.main.home.podcasts.ui.impl.podcastsImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val navigationController = rememberNavController()

            NavHost(
                navController = navigationController,
                startDestination = Screens.Home
            ) {

                navigation<Screens.Home>(startDestination = HomeSubscreens.Podcasts) {

                    podcastsImpl(navigationController = navigationController)

                    habitTrackerImpl(navigationController = navigationController)
                }
            }
        }
    }
}