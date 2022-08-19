package com.alexpetrov.model.entities.local.main

import com.alexpetrov.model.entities.local.ILocalData

data class HomeStore(
    val id: Int?,
    val isNew: Boolean?,
    val title: String?,
    val subtitle: String?,
    val picture: String?
) : ILocalData