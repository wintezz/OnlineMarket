package com.alexpetrov.repositories.api

import com.alexpetrov.model.entities.responce.main.ResponseMain
import com.alexpetrov.model.entities.responce.productdetails.ResponseProductDetails
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/rest/main")
    fun getMainAsync(): Deferred<List<ResponseMain>>

    @GET("/rest/productdetails")
    fun getProductDetailsAsync(): Deferred<List<ResponseProductDetails>>
}