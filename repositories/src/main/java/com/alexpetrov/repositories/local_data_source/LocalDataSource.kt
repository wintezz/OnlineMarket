package com.alexpetrov.repositories.local_data_source

import com.alexpetrov.model.entities.local.ILocalData

interface LocalDataSource<T: ILocalData> {
    suspend fun getData(id: String): T?
    suspend fun addData(id: String, data: T)
}