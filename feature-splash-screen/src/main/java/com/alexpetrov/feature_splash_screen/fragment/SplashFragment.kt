package com.alexpetrov.feature_splash_screen.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alexpetrov.feature_splash_screen.R
import com.alexpetrov.feature_splash_screen.view_model.SplashViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.toMainScreen(TIME_TO_START_SCREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    companion object {
        private const val TIME_TO_START_SCREEN: Long = 1000
    }
}