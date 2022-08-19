package com.alexpetrov.feature_my_cart.data

import com.alexpetrov.feature_my_cart.data.model.remote.ResponseCart

class MyCartRemoteDataSourceImpl(private val api: MyCartService) : MyCartRemoteDataSource {
    override suspend fun getMyCart(): List<ResponseCart> = api.getMyCartAsync().await()
}