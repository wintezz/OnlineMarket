package com.alexpetrov.onlinemarket.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.alexpetrov.onlinemarket.R
import com.alexpetrov.onlinemarket.view_model.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val navigatorHolder: NavigatorHolder by inject()
    private var navigator: AppNavigator? = null
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initNavigation()

        if (supportFragmentManager.fragments.isEmpty()) {
            viewModel.toSplashScreen()
        }
    }

    private fun initNavigation() {
        navigator = AppNavigator(this, R.id.container)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigator?.let {
            navigatorHolder.setNavigator(it)
        }
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}