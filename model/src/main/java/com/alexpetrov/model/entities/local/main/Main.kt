package com.alexpetrov.model.entities.local.main

import com.alexpetrov.model.entities.local.ILocalData

data class Main(
    val id: String?,
    val homeStore: List<HomeStore>?,
    val bestSeller: List<BestSeller>?
) : ILocalData