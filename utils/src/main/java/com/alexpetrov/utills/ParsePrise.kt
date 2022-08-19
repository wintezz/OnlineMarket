package com.alexpetrov.utills

import java.lang.StringBuilder

fun parseIntToPriceForItemMyCart(price: Int): String = "$${price}.00"

fun mapIntToPriceForBestSeller(price: Int): String {
    val strPrise = StringBuilder(price.toString())
    val newPrice: String =
        if (price >= 100000) {
            strPrise.insert(3, ",")
            strPrise.toString()
        } else if (price >= 10000) {
            strPrise.insert(2, ",")
            strPrise.toString()
        } else if (price >= 1000) {
            strPrise.insert(1, ",")
            strPrise.toString()
        } else {
            price.toString()
        }

    return "$$newPrice"
}

fun mapIntToPriceForProductDetails(price: Int): String = "${mapIntToPriceForBestSeller(price)}.00"

fun parseIntToPriceForMyCart(price: Int): String = "${mapIntToPriceForBestSeller(price)} us"