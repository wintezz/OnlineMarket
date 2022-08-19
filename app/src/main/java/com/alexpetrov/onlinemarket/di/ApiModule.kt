package com.alexpetrov.onlinemarket.di

import com.alexpetrov.core.remote.RetrofitBuilder
import com.alexpetrov.repositories.api.ApiService
import org.koin.dsl.module

val retrofitModule = module {
    single { RetrofitBuilder.create(ApiService::class.java) }
}
