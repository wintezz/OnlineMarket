package com.alexpetrov.repositories.data_source

import com.alexpetrov.model.entities.responce.main.ResponseMain
import com.alexpetrov.model.entities.responce.productdetails.ResponseProductDetails

interface RemoteDataSource {
    suspend fun getMain(): List<ResponseMain>
    suspend fun getProductDetails(): List<ResponseProductDetails>
}