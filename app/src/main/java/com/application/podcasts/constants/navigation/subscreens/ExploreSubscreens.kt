package com.application.podcasts.constants.navigation.subscreens

import kotlinx.serialization.Serializable

sealed class ExploreSubscreens {

    @Serializable object Explore: ExploreSubscreens()

    @Serializable object ExploreByLanguage: ExploreSubscreens()
}