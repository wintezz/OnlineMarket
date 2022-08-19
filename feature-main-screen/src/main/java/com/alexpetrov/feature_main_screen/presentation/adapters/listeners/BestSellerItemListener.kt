package com.alexpetrov.feature_main_screen.presentation.adapters.listeners

import com.alexpetrov.core.adapter.BaseItemListener

interface BestSellerItemListener: BaseItemListener {
    fun itemListener(id: String)
}