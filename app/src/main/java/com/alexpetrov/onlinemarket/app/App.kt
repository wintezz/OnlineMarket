package com.alexpetrov.onlinemarket.app

import android.app.Application
import com.alexpetrov.feature_my_cart.myCartModule
import com.alexpetrov.onlinemarket.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:  Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                retrofitModule,
                dataSourceModule,
                viewModelModule,
                repositoryModule,
                interactorModule,
                ciceroneModule,
                navigationModule,
                imageModule,
                myCartModule
                )
        }
    }
}