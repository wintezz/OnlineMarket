package com.alexpetrov.model.entities.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.alexpetrov.model.entities.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseHomeStore(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val picture: String
) : Parcelable, IResponseData