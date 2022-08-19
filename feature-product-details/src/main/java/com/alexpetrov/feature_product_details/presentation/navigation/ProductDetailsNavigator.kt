package com.alexpetrov.feature_product_details.presentation.navigation

import com.alexpetrov.core.navigation.BaseNavigator

interface ProductDetailsNavigator: BaseNavigator {
    fun toMyCartFragment()
}