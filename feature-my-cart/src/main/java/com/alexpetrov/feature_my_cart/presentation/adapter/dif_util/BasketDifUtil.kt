package com.alexpetrov.feature_my_cart.presentation.adapter.dif_util

import androidx.recyclerview.widget.DiffUtil
import com.alexpetrov.feature_my_cart.data.model.local.Basket

class BasketDifUtil : DiffUtil.ItemCallback<Basket>() {
    override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem == newItem
    }
}