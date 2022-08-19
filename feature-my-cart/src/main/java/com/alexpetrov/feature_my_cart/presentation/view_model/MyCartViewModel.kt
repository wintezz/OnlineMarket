package com.alexpetrov.feature_my_cart.presentation.view_model

import com.alexpetrov.core.view_model.BaseViewModel
import com.alexpetrov.feature_my_cart.data.model.local.Cart
import com.alexpetrov.feature_my_cart.domain.MyCartInteractor
import com.alexpetrov.feature_my_cart.presentation.navigation.MyCartNavigator
import com.alexpetrov.model.state.AppState

class MyCartViewModel(
    private val interactor: MyCartInteractor,
    private val navigator: MyCartNavigator
) :
    BaseViewModel<Cart>() {

    fun getData() = runAsync {
        _liveData.postValue(AppState.Success(interactor.getCart()))
    }

    fun onBackPressed() {
        navigator.onBackPressed()
    }
}