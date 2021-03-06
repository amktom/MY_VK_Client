package com.example.my_vk_client.dagger.module

import android.content.Context
import android.content.SharedPreferences
import com.example.my_vk_client.App
import com.example.my_vk_client.data.repo.repository.PostRepositoryImpl
import com.example.my_vk_client.data.repo.repository.ProfileRepositoryImpl
import com.example.my_vk_client.data.repo.repository.SessionRepositoryImpl
import com.example.my_vk_client.data.repo.source.*
import com.example.my_vk_client.domain.repo.repository.PostRepository
import com.example.my_vk_client.domain.repo.repository.ProfileRepository
import com.example.my_vk_client.domain.repo.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(
    includes = [
        NetworkModule::class,
        ConverterModule::class
    ]
)
abstract class DataModule {

    @Module
    companion object {

        @JvmStatic
        @Reusable
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
            app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)

    }

    @Reusable
    @Binds
    abstract fun bindAuthSource(instance: AuthSourceImpl): AuthSource

    @Reusable
    @Binds
    abstract fun bindProfileSource(instance: ProfileSourceImpl): ProfileSource

    @Reusable
    @Binds
    abstract fun bindSessionDataSource(instance: SessionSourceImpl): SessionSource

    @Reusable
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    abstract fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Reusable
    @Binds
    abstract fun bindPostDataSource(instance: PostDataSourceImpl): PostDataSource


}