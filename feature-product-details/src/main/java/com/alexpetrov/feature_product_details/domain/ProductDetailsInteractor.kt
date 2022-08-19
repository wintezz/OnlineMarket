package com.alexpetrov.feature_product_details.domain

import com.alexpetrov.model.entities.local.productdetails.ProductDetails

interface ProductDetailsInteractor {
    suspend fun getProductDetails(id: String): ProductDetails?
}