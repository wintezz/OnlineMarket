package com.alexpetrov.onlinemarket.di

import com.alexpetrov.feature_main_screen.presentation.view_model.MainScreenViewModel
import com.alexpetrov.feature_product_details.presentation.view_moldel.ProductDetailsViewModel
import com.alexpetrov.feature_splash_screen.view_model.SplashViewModel
import com.alexpetrov.onlinemarket.view_model.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainScreenViewModel(get(), get()) }
    viewModel { ProductDetailsViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}