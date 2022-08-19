package com.alexpetrov.repositories.data_source

import com.alexpetrov.model.entities.responce.main.ResponseMain
import com.alexpetrov.model.entities.responce.productdetails.ResponseProductDetails
import com.alexpetrov.repositories.api.ApiService

class RemoteDataSourceImpl(private val api: ApiService) :
    RemoteDataSource {
    override suspend fun getMain(): List<ResponseMain> = api.getMainAsync().await()
    override suspend fun getProductDetails(): List<ResponseProductDetails> =
        api.getProductDetailsAsync().await()
}