package com.alexpetrov.feature_product_details.presentation.view_moldel

import com.alexpetrov.core.view_model.BaseViewModel
import com.alexpetrov.model.entities.local.productdetails.ProductDetails
import com.alexpetrov.model.state.AppState
import com.alexpetrov.feature_product_details.presentation.navigation.ProductDetailsNavigator
import com.alexpetrov.feature_product_details.domain.ProductDetailsInteractor

class ProductDetailsViewModel(
    private val interactor: ProductDetailsInteractor,
    private val navigator: ProductDetailsNavigator
) :
    BaseViewModel<ProductDetails>() {
    fun getData(id: String) = runAsync {
        val data = interactor.getProductDetails(id)
        data?.let { _liveData.postValue(AppState.Success(it)) }
    }

    fun onBackPressed() {
        navigator.onBackPressed()
    }

    fun toMyCartScreen() {
        navigator.toMyCartFragment()
    }
}