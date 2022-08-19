package com.alexpetrov.onlinemarket.navigation

import com.github.terrakok.cicerone.Router
import com.alexpetrov.feature_splash_screen.navigation.SplashNavigator

class SplashNavigatorImpl(private val router: Router, private val screens: Screens) :
    SplashNavigator {
    override fun toMainScreen() {
        router.replaceScreen(screens.mainScreen())
    }

    override fun onBackPressed() {
        router.exit()
    }
}