package com.alexpetrov.model.entities.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.alexpetrov.model.entities.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseBestSeller(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val priceWithoutDiscount: Int,
    @SerializedName("discount_price") val discountPrice: Int,
    @SerializedName("picture") val picture: String
) : Parcelable, IResponseData

