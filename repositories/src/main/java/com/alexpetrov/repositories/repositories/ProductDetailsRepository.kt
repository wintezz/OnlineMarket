package com.alexpetrov.repositories.repositories

import com.alexpetrov.model.entities.local.productdetails.ProductDetails

interface ProductDetailsRepository {
    suspend fun getProductDetails(id: String): ProductDetails?
}