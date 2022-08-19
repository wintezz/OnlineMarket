package com.alexpetrov.model.state

import com.alexpetrov.model.entities.local.ILocalData

sealed class AppState<out T: ILocalData> {
    data class Success<out T: ILocalData>(val data: T) : AppState<T>()
    class Loading<out T: ILocalData>() : AppState<T>()
    data class Error<out T: ILocalData>(val error: Throwable) : AppState<T>()
}