package com.alexpetrov.core.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.alexpetrov.core.view_model.BaseViewModel
import com.alexpetrov.model.entities.local.ILocalData
import com.alexpetrov.model.state.AppState

abstract class BaseFragment<VB : ViewBinding, T : ILocalData, VM : BaseViewModel<T>>(layout: Int) :
    Fragment(layout) {

    protected abstract val viewBinding: VB?
    protected abstract val viewModel: VM

    private fun renderData(state: AppState<T>) {
        when (state) {
            is AppState.Error -> renderError(state.error)
            is AppState.Loading -> showLoading()
            is AppState.Success -> renderSuccess(state.data)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner) {
            renderData(it)
        }
    }

    protected abstract fun renderSuccess(data: T)

    protected open fun showLoading() {}

    protected open fun renderError(error: Throwable) {
        error.message?.let { showToast(it) }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show()
    }
}