package com.alexpetrov.feature_main_screen.presentation.adapters.binds

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import com.alexpetrov.core.adapter.BaseItemListener
import com.alexpetrov.feature_main_screen.R
import com.alexpetrov.feature_main_screen.presentation.adapters.listeners.BestSellerItemListener
import com.alexpetrov.feature_main_screen.databinding.ItemBestSellerBinding
import com.alexpetrov.feature_main_screen.databinding.ItemHotSalesBinding
import com.alexpetrov.model.entities.local.main.BestSeller
import com.alexpetrov.model.entities.local.main.HomeStore
import com.alexpetrov.repositories.image_loader.ImageLoader
import com.alexpetrov.utills.mapIntToPriceForBestSeller

internal fun bindHotSales(
    view: View,
    data: HomeStore,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemHotSalesBinding.bind(view)
    val urlPicture = data.picture
    val title = data.title
    val subtitle = data.subtitle
    val isNew = data.isNew ?: false
    with(binding) {
        urlPicture?.let {
            imageLoader.loadImage(it, ivPhoneHotSales)
        }
        tvPhoneName.text = title
        tvPhoneDescription.text = subtitle
        if (!isNew) ivNew.visibility = View.INVISIBLE
    }

}

internal fun bindBestSeller(
    view: View,
    data: BestSeller,
    listener: BestSellerItemListener,
    imageLoader: ImageLoader
) {
    val binding: ItemBestSellerBinding = ItemBestSellerBinding.bind(view)
    val discountPrise = mapIntToPriceForBestSeller(data.discountPrice ?: 0)
    val priceWithoutDiscount = mapIntToPriceForBestSeller(data.priceWithoutDiscount ?: 0)
    val uri = data.picture
    val isFavorites = data.isFavorites ?: false
    val title = data.title

    val span = SpannableString(priceWithoutDiscount)
    span.setSpan(StrikethroughSpan(), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    view.setOnClickListener {
        listener.itemListener(data.id.toString())
    }

    with(binding) {
        uri?.let { imageLoader.loadImage(it, ivPhoneBestSeller) }
        tvModelPhone.text = title
        tvDiscountPrice.text = discountPrise
        tvPriceWithoutDiscount.text = span
        if (isFavorites) ivLikeBestSeller.setImageResource(R.drawable.like)
    }
}