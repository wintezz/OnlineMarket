package com.alexpetrov.feature_my_cart

import com.alexpetrov.core.remote.RetrofitBuilder
import com.alexpetrov.feature_my_cart.data.MyCartRemoteDataSource
import com.alexpetrov.feature_my_cart.data.MyCartRemoteDataSourceImpl
import com.alexpetrov.feature_my_cart.data.MyCartRepositoryImpl
import com.alexpetrov.feature_my_cart.data.MyCartService
import com.alexpetrov.feature_my_cart.domain.MyCartInteractor
import com.alexpetrov.feature_my_cart.domain.MyCartInteractorImpl
import com.alexpetrov.feature_my_cart.domain.MyCartRepository
import com.alexpetrov.feature_my_cart.presentation.view_model.MyCartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myCartModule = module {
    single { RetrofitBuilder.create(MyCartService::class.java) }
    factory<MyCartRemoteDataSource> { MyCartRemoteDataSourceImpl(get()) }
    factory<MyCartRepository> { MyCartRepositoryImpl(get()) }
    factory<MyCartInteractor> { MyCartInteractorImpl(get()) }

    viewModel { MyCartViewModel(get(), get()) }
}