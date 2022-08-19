package com.alexpetrov.feature_my_cart.data.model.local

import com.alexpetrov.model.entities.local.ILocalData

data class Cart(
    val id: String?,
    val basket: List<Basket>?,
    val total: Int?,
    val delivery: String?
) : ILocalData