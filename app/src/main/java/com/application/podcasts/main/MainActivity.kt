package com.application.podcasts.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.application.podcasts.constants.navigation.Navigation
import com.application.podcasts.main.account.ui.impl.accountImpl
import com.application.podcasts.main.explore.explore.ui.impl.exploreImpl
import com.application.podcasts.main.explore.filter.ui.impl.filterImpl
import com.application.podcasts.main.explore.search.ui.impl.searchImpl
import com.application.podcasts.main.explore.selectLanguage.ui.impl.selectLanguageImpl
import com.application.podcasts.main.home.habitTracker.ui.impl.habitTrackerImpl
import com.application.podcasts.main.home.podcasts.ui.impl.podcastsImpl
import com.application.podcasts.main.library.ui.impl.libraryImpl
import com.application.podcasts.screenNavigationBar.ui.impl.ScreenNavigationBarImpl
import com.application.podcasts.subscreenNavigationBar.ui.impl.SubscreenNavigationBarImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val navHostController = rememberNavController()

            Scaffold(

                modifier = Modifier
                    .fillMaxSize(),

                topBar = {

                    SubscreenNavigationBarImpl(
                        navHostController = navHostController
                    )
                },

                bottomBar = {

                    ScreenNavigationBarImpl(
                        navHostController = navHostController
                    )
                },

                content = {

                    NavHost(

                        navController = navHostController,
                        startDestination = Navigation.RouteHome.HomeScreen,

                        builder = {

                            navigation<Navigation.RouteHome.HomeScreen>(startDestination = Navigation.RouteHome.PodcastsSubscreen) {

                                podcastsImpl()

                                habitTrackerImpl()
                            }

                            navigation<Navigation.RouteExplore.ExploreScreen>(startDestination = Navigation.RouteExplore.ExploreSubscreen) {

                                searchImpl()

                                exploreImpl()

                                selectLanguageImpl()

                                filterImpl()
                            }

                            navigation<Navigation.RouteLibrary.LibraryScreen>(startDestination = Navigation.RouteLibrary.LibrarySubscreen) {

                                libraryImpl()
                            }

                            navigation<Navigation.RouteAccount.AccountScreen>(startDestination = Navigation.RouteAccount.AccountSubscreen) {

                                accountImpl()
                            }
                        }
                    )
                }
            )
        }
    }
}