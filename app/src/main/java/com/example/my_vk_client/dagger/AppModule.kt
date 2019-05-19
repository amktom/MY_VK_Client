package com.example.my_vk_client.dagger

import com.example.my_vk_client.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun  provideMainActivity(): MainActivity

}