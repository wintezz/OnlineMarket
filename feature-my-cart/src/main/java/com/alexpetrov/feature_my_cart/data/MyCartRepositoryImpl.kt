package com.alexpetrov.feature_my_cart.data

import com.alexpetrov.feature_my_cart.data.model.local.Basket
import com.alexpetrov.feature_my_cart.data.model.local.Cart
import com.alexpetrov.feature_my_cart.data.model.remote.ResponseBasket
import com.alexpetrov.feature_my_cart.data.model.remote.ResponseCart
import com.alexpetrov.feature_my_cart.domain.MyCartRepository

class MyCartRepositoryImpl(private val dataSource: MyCartRemoteDataSource) :
    MyCartRepository {
    override suspend fun getCart(): Cart {
        val listResponseCart = dataSource.getMyCart()
        return mapToCart(listResponseCart)
    }

    private fun mapToCart(response: List<ResponseCart>): Cart {
        val responseCart = response[0]
        val basket = responseCart.basket?.let { mapToListBasket(it) }
        return Cart(
            id = responseCart.id,
            basket = basket,
            total = responseCart.total,
            delivery = responseCart.delivery
        )
    }

    private fun mapToListBasket(rBasket: List<ResponseBasket>): List<Basket> =
        rBasket.map { responseBasket ->
            Basket(
                id = rBasket.indexOf(responseBasket),
                images = responseBasket.images,
                title = responseBasket.title,
                price = responseBasket.price
            )
        }
}