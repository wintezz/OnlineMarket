package com.alexpetrov.feature_my_cart.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alexpetrov.feature_my_cart.data.model.local.Basket
import com.alexpetrov.feature_my_cart.databinding.ItemRvMyCartBinding
import com.alexpetrov.feature_my_cart.presentation.adapter.dif_util.BasketDifUtil
import com.alexpetrov.repositories.image_loader.ImageLoader
import com.alexpetrov.utills.parseIntToPriceForItemMyCart

class CartAdapter(private val imageLoader: ImageLoader) :
    ListAdapter<Basket, CartAdapter.CartViewHolder>(BasketDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRvMyCartBinding.inflate(layoutInflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CartViewHolder(private val binding: ItemRvMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Basket) {
            with(binding) {
                item.images?.let { imageLoader.loadImage(it, ivPhonePhotoMyCart) }
                tvPhoneNameMyCart.text = item.title
                tvPhonePriceMyCart.text = parseIntToPriceForItemMyCart(item.price ?: 0)

                ivBasketMayCart.setOnClickListener {
                    deleteItem()
                }
            }
        }

        private fun deleteItem() {
            val newList: MutableList<Basket> = mutableListOf()
            newList.addAll(currentList)
            newList.removeAt(layoutPosition)
            submitList(newList.toList())
        }
    }
}