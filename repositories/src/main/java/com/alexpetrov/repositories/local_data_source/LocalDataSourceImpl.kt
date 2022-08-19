package com.alexpetrov.repositories.local_data_source

import com.alexpetrov.model.entities.local.productdetails.ListProductDetails
import com.alexpetrov.model.entities.local.productdetails.ProductDetails

class LocalDataSourceImpl(private val mapPhones: ListProductDetails) :
    LocalDataSource<ProductDetails> {
    override suspend fun getData(id: String): ProductDetails? = mapPhones.mapProductDetails[id]

    override suspend fun addData(id: String, data: ProductDetails) {
        mapPhones.mapProductDetails[id] = data
    }
}