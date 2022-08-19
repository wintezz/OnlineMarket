package com.alexpetrov.feature_my_cart.domain

import com.alexpetrov.feature_my_cart.data.model.local.Cart

interface MyCartRepository {
    suspend fun getCart(): Cart
}