package com.alexpetrov.feature_main_screen.presentation.navigation

import com.alexpetrov.core.navigation.BaseNavigator

interface MainScreenNavigator : BaseNavigator {
    fun toProductDetailsScreen(id: String)
}
