package com.alexpetrov.feature_my_cart.presentation.fragment

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexpetrov.core.view.BaseFragment
import com.alexpetrov.feature_my_cart.R
import com.alexpetrov.feature_my_cart.presentation.adapter.CartAdapter
import com.alexpetrov.feature_my_cart.databinding.FragmentMyCartBinding
import com.alexpetrov.feature_my_cart.presentation.view_model.MyCartViewModel
import com.alexpetrov.feature_my_cart.data.model.local.Cart
import com.alexpetrov.repositories.image_loader.ImageLoader
import com.alexpetrov.utills.parseIntToPriceForMyCart
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MyCartFragment :
    BaseFragment<FragmentMyCartBinding, Cart, MyCartViewModel>(R.layout.fragment_my_cart) {
    override val viewBinding: FragmentMyCartBinding by viewBinding()
    override val viewModel: MyCartViewModel by viewModel()
    private var adapter: CartAdapter? = null

    private val imageLoader: ImageLoader by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    private fun init() {
        initAdapter()

        with(viewBinding) {
            buttonBackContainerMyCart.setOnClickListener {
                viewModel.onBackPressed()
            }
        }
    }

    private fun initAdapter() {
        adapter = CartAdapter(imageLoader)

        adapter?.let {
            viewBinding.bottomSheetMyCart.rvMyCart.adapter = it
        }
    }

    override fun renderSuccess(data: Cart) {
        initView(data)
    }

    private fun initView(data: Cart) {
        data.basket?.let { adapter?.submitList(it) }
        with(viewBinding.bottomSheetMyCart) {
            tvTotalValueMyCart.text = parseIntToPriceForMyCart(data.total ?: 0)
            tvDeliveryValueMyCart.text = data.delivery
        }
    }
}