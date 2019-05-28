package com.example.my_vk_client.dagger.module

import dagger.Module

@Module(includes = [
    AppModule::class,
    MainActivityModule::class,
    NavigationModule::class
])
interface PresentationModule