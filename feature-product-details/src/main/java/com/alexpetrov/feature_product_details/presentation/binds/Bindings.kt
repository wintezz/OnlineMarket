package com.alexpetrov.feature_product_details.presentation.binds

import android.view.View
import com.alexpetrov.core.adapter.BaseItemListener
import com.alexpetrov.feature_product_details.databinding.ItemPhotoPhoneBinding
import com.alexpetrov.repositories.image_loader.ImageLoader

fun bindProductDetails(
    view: View,
    data: String,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemPhotoPhoneBinding.bind(view)
    imageLoader.loadImage(data, binding.ivPhoneItemPhotoPhone)
}