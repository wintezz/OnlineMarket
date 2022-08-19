package com.alexpetrov.feature_my_cart.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.alexpetrov.model.entities.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseCart(
    @SerializedName("_id") val id: String?,
    @SerializedName("basket") val basket: List<ResponseBasket>?,
    @SerializedName("total") val total: Int?,
    @SerializedName("Delivery") val delivery: String?
) : Parcelable, IResponseData