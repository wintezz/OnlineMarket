package com.alexpetrov.feature_main_screen.domain

import com.alexpetrov.model.entities.local.main.Main

interface MainInteractor {
    suspend fun getMain(): Main
}