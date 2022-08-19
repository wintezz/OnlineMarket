package com.alexpetrov.onlinemarket.view_model

import androidx.lifecycle.ViewModel
import com.alexpetrov.onlinemarket.navigation.MainNavigator

class MainViewModel(private val navigator: MainNavigator): ViewModel() {

    fun toSplashScreen(){
        navigator.toSplashScreen()
    }
}