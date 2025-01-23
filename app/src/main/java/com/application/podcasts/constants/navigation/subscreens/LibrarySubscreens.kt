package com.application.podcasts.constants.navigation.subscreens

import kotlinx.serialization.Serializable

sealed class LibrarySubscreens {

    @Serializable
    object Library: LibrarySubscreens()
}