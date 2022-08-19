package com.alexpetrov.onlinemarket.di

import com.alexpetrov.feature_main_screen.domain.MainInteractor
import com.alexpetrov.feature_main_screen.domain.MainInteractorImpl
import com.alexpetrov.feature_product_details.domain.ProductDetailsInteractor
import com.alexpetrov.feature_product_details.domain.ProductDetailsInteractorImpl
import com.alexpetrov.model.entities.local.productdetails.ListProductDetails
import com.alexpetrov.model.entities.local.productdetails.ProductDetails
import com.alexpetrov.repositories.data_source.RemoteDataSource
import com.alexpetrov.repositories.data_source.RemoteDataSourceImpl
import com.alexpetrov.repositories.image_loader.GlideImageLoader
import com.alexpetrov.repositories.image_loader.ImageLoader
import com.alexpetrov.repositories.local_data_source.LocalDataSource
import com.alexpetrov.repositories.local_data_source.LocalDataSourceImpl
import com.alexpetrov.repositories.repositories.MainRepository
import com.alexpetrov.repositories.repositories.MainRepositoryImpl
import com.alexpetrov.repositories.repositories.ProductDetailsRepository
import com.alexpetrov.repositories.repositories.ProductDetailsRepositoryImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LocalDataSource<ProductDetails>> { LocalDataSourceImpl(get()) }
}

val repositoryModule = module {
    single { ListProductDetails() }
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<ProductDetailsRepository> { ProductDetailsRepositoryImpl(get(), get()) }
}

val interactorModule = module {
    single<MainInteractor> { MainInteractorImpl(get()) }
    single<ProductDetailsInteractor> { ProductDetailsInteractorImpl(get()) }
}

val imageModule = module {
    single<ImageLoader> { GlideImageLoader() }
}