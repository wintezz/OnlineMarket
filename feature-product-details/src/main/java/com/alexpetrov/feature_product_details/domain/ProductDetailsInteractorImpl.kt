package com.alexpetrov.feature_product_details.domain

import com.alexpetrov.model.entities.local.productdetails.ProductDetails
import com.alexpetrov.repositories.repositories.ProductDetailsRepository

class ProductDetailsInteractorImpl(private val repository: ProductDetailsRepository) :
    ProductDetailsInteractor {

    override suspend fun getProductDetails(id: String): ProductDetails? =
        repository.getProductDetails(id)
}