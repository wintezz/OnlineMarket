package com.alexpetrov.repositories.repositories

import com.alexpetrov.model.entities.local.main.Main

interface MainRepository {
    suspend fun getMain(): Main
}