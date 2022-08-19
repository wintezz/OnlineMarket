package com.alexpetrov.feature_my_cart.data.model.remote

import android.os.Parcelable
import com.alexpetrov.model.entities.responce.IResponseData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ResponseBasket(
    @SerializedName("image") val images: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("price") val price: Int?
) : Parcelable, IResponseData