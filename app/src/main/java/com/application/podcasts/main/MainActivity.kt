package com.application.podcasts.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.application.podcasts.constants.navigation.screens.CurrentScreen
import com.application.podcasts.constants.navigation.screens.Screens
import com.application.podcasts.constants.navigation.subscreens.ExploreSubscreens
import com.application.podcasts.constants.navigation.subscreens.HomeSubscreens
import com.application.podcasts.constants.navigation.subscreens.LibrarySubscreens
import com.application.podcasts.main.explore.explore.ui.impl.exploreImpl
import com.application.podcasts.main.home.habitTracker.ui.impl.habitTrackerImpl
import com.application.podcasts.main.home.podcasts.ui.impl.podcastsImpl
import com.application.podcasts.sharedUI.commonComponents.bottomBar
import com.application.podcasts.sharedUI.commonComponents.topBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val navigationController = rememberNavController()

            Scaffold(

                modifier = Modifier
                    .fillMaxSize(),

                topBar = {

                    topBar()
                },

                bottomBar = {

                    bottomBar(

                        flowOfNavBackStackEntry = navigationController.currentBackStackEntryFlow,

                        onNavigate = {

                            val targetScreen = when(it) {
                                CurrentScreen.Explore -> Screens.Explore
                                CurrentScreen.Home -> Screens.Home
                                CurrentScreen.Library -> Screens.Library
                            }

                            navigationController.navigate(route = targetScreen)
                        }
                    )
                },

                content = {

                    NavHost(

                        navController = navigationController,
                        startDestination = Screens.Home,

                        builder = {

                            navigation<Screens.Home>(startDestination = HomeSubscreens.Podcasts) {

                                podcastsImpl(navigationController = navigationController)

                                habitTrackerImpl(navigationController = navigationController)
                            }

                            navigation<Screens.Explore>(startDestination = ExploreSubscreens.Explore) {

                                exploreImpl()
                            }

                            navigation<Screens.Library>(startDestination = LibrarySubscreens.Library) {

                                composable<LibrarySubscreens.Library> {

                                    Text("")
                                }
                            }
                        }
                    )
                }
            )
        }
    }
}