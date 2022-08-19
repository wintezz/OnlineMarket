package com.alexpetrov.feature_main_screen.domain

import com.alexpetrov.model.entities.local.main.Main
import com.alexpetrov.repositories.repositories.MainRepository

class MainInteractorImpl(private val repository: MainRepository) :
    MainInteractor {

    override suspend fun getMain(): Main = repository.getMain()
}