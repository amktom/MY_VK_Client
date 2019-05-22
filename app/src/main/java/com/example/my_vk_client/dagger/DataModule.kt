package com.example.my_vk_client.dagger

import com.example.my_vk_client.data.repo.SessionRepositoryImpl
import com.example.my_vk_client.domain.repo.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface DataModule {

    @Reusable
    @Binds
    fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository
}
