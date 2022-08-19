package com.alexpetrov.feature_product_details.presentation.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alexpetrov.core.adapter.BaseAdapter
import com.alexpetrov.core.adapter.BaseItemListener
import com.alexpetrov.core.view.BaseFragment
import com.alexpetrov.feature_product_details.R
import com.alexpetrov.feature_product_details.presentation.binds.bindProductDetails
import com.alexpetrov.feature_product_details.databinding.FragmentProductDetailsBinding
import com.alexpetrov.feature_product_details.presentation.view_moldel.ProductDetailsViewModel
import com.alexpetrov.model.entities.local.productdetails.ProductDetails
import com.alexpetrov.repositories.image_loader.ImageLoader
import com.alexpetrov.utills.mapIntToPriceForProductDetails
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding, ProductDetails, ProductDetailsViewModel>(
        R.layout.fragment_product_details
    ) {

    override val viewBinding: FragmentProductDetailsBinding by viewBinding()
    override val viewModel: ProductDetailsViewModel by viewModel()
    private val imageLoader: ImageLoader by inject()
    private var adapter: BaseAdapter<String, BaseItemListener>? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString(KEY_ID_PHONE)
        id?.let { viewModel.getData(it) }
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    private fun init() {
        viewBinding.buttonBackContainerProductDetails.setOnClickListener {
            viewModel.onBackPressed()
        }

        viewBinding.ivCartContainerProductDetails.setOnClickListener {
            viewModel.toMyCartScreen()
        }
        initColorImagesListener()
        initAdapter()
        initSelectColor()
    }

    private fun initSelectColor() {
        with(viewBinding.bottomSheet) {
            buttonSSD1.setOnClickListener { selectButtonSSD1() }
            buttonSSD2.setOnClickListener { selectButtonSSD2() }
        }
    }

    private fun selectButtonSSD1() {
        with(viewBinding.bottomSheet.buttonSSD1) {
            setBackgroundColor(resources.getColor(R.color.orange, context.theme))
            setTextColor(resources.getColor(R.color.white, context.theme))
        }

        with(viewBinding.bottomSheet.buttonSSD2) {
            setBackgroundColor(resources.getColor(R.color.white, context.theme))
            setTextColor(resources.getColor(R.color.shade_gray, context.theme))
        }
    }

    private fun selectButtonSSD2() {
        with(viewBinding.bottomSheet.buttonSSD2) {
            setBackgroundColor(resources.getColor(R.color.orange, context.theme))
            setTextColor(resources.getColor(R.color.white, context.theme))
        }

        with(viewBinding.bottomSheet.buttonSSD1) {
            setBackgroundColor(resources.getColor(R.color.white, context.theme))
            setTextColor(resources.getColor(R.color.shade_gray, context.theme))
        }
    }

    private fun initColorImagesListener() {
        with(viewBinding.bottomSheet) {
            ivColor1ProductDetails.setOnClickListener {
                if (checkMark1.visibility == View.INVISIBLE) {
                    checkMark1.visibility = View.VISIBLE
                    if (checkMark2.visibility == View.VISIBLE) {
                        checkMark2.visibility = View.INVISIBLE
                    }
                }
            }

            ivColor2ProductDetails.setOnClickListener {
                if (checkMark2.visibility == View.INVISIBLE) {
                    checkMark2.visibility = View.VISIBLE
                    if (checkMark1.visibility == View.VISIBLE) {
                        checkMark1.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = BaseAdapter(R.layout.item_photo_phone, listener) { view, data, listener ->
            bindProductDetails(view, data, listener, imageLoader)
        }
        viewBinding.rvImagePhoneProductDetails.setItemTransformer(
            ScaleTransformer.Builder()
                .setMaxScale(MAX_SCALE)
                .setMinScale(MIN_SCALE)
                .setPivotX(Pivot.X.CENTER)
                .setPivotY(Pivot.Y.CENTER)
                .build()
        )
        adapter?.let { viewBinding.rvImagePhoneProductDetails.adapter = it }
    }

    override fun renderSuccess(data: ProductDetails) {
        initViews(data)
        adapter?.setData(data.images)
    }

    private fun initViews(data: ProductDetails) {
        with(viewBinding.bottomSheet) {
            tvModelPhoneProductDetails.text = data.title
            tvCamera.text = data.camera
            tvCpu.text = data.CPU
            tvSsd.text = data.ssd
            tvSd.text = data.sd
            val colorOne = Color.parseColor(data.color[0])
            val colorTwo = Color.parseColor(data.color[1])
            val textButton = mapIntToPriceForProductDetails(data.price)

            ivColor1ProductDetails.setColorFilter(colorOne)
            ivColor2ProductDetails.setColorFilter(colorTwo)

            buttonSSD1.text = data.capacity[0]
            buttonSSD2.text = data.capacity[1]

            tvPricePhone.text = textButton

            initRating(data.rating)

        }

    }

    private fun initRating(rating: Double) {
        val colorYellow = context?.resources?.getColor(R.color.color_stars, context?.theme)

        with(viewBinding.bottomSheet) {
            colorYellow?.let {
                when (rating) {
                    in 0.3..0.5 -> {
                        ivStar1.setImageResource(R.drawable.ic_baseline_star)
                    }
                    in 0.3..1.0 -> {
                        ivStar1.setColorFilter(it)
                    }
                    in 1.3..1.5 -> {
                        ivStar1.setBackgroundColor(it)
                        ivStar2.setImageResource(R.drawable.ic_baseline_star)
                    }
                    in 1.5..2.3 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                    }
                    in 2.3..2.5 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setImageResource(R.drawable.ic_baseline_star)
                    }
                    in 2.5..3.3 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setColorFilter(it)
                    }
                    in 3.3..3.5 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setColorFilter(it)
                        ivStar4.setImageResource(R.drawable.ic_baseline_star)
                    }
                    in 3.5..4.3 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setColorFilter(it)
                        ivStar4.setColorFilter(it)
                    }
                    in 4.3..4.5 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setColorFilter(it)
                        ivStar4.setColorFilter(it)
                        ivStar5.setImageResource(R.drawable.ic_baseline_star)
                    }
                    in 4.5..5.0 -> {
                        ivStar1.setColorFilter(it)
                        ivStar2.setColorFilter(it)
                        ivStar3.setColorFilter(it)
                        ivStar4.setColorFilter(it)
                        ivStar5.setImageResource(R.drawable.ic_baseline_star)
                    }
                }
            }
        }
    }

    private val listener = object : BaseItemListener {}

    companion object {
        private const val KEY_ID_PHONE = "key id phone"
        private const val MIN_SCALE: Float = 0.7F
        private const val MAX_SCALE: Float = 1.0F

        fun newInstance(id: String) =
            ProductDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_ID_PHONE, id)
                }
            }
    }
}