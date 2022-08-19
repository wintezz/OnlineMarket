package com.alexpetrov.model.entities.local.main

import com.alexpetrov.model.entities.local.ILocalData

data class BestSeller(
    val id: Int?,
    val isFavorites: Boolean?,
    val title: String?,
    val priceWithoutDiscount: Int?,
    val discountPrice: Int?,
    val picture: String?
) : ILocalData

