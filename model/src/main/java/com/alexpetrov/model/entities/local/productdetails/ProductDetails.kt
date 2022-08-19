package com.alexpetrov.model.entities.local.productdetails

import com.alexpetrov.model.entities.local.ILocalData

data class ProductDetails(
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val title: String,
    val rating: Double,
    val CPU: String,
    val camera: String,
    val ssd: String,
    val sd: String,
    val color: List<String>,
    val capacity: List<String>,
    val price: Int
) : ILocalData