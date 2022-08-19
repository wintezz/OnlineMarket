package com.alexpetrov.model.entities.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.alexpetrov.model.entities.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseMain(
    @SerializedName("_id") val id: String,
    @SerializedName("home_store") val homeStore: List<ResponseHomeStore>,
    @SerializedName("best_seller") val bestSeller: List<ResponseBestSeller>
) : Parcelable, IResponseData