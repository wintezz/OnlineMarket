package com.alexpetrov.onlinemarket.navigation

import com.github.terrakok.cicerone.Router
import com.alexpetrov.feature_product_details.presentation.navigation.ProductDetailsNavigator

class ProductDetailsNavigatorImpl(
    private val screens: Screens,
    private val router: Router) : ProductDetailsNavigator {

   override fun onBackPressed() {
        router.exit()
    }

    override fun toMyCartFragment() {
        router.navigateTo(screens.myCartScreen())
    }
}