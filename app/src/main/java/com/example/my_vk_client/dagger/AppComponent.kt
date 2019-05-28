package com.example.my_vk_client.dagger

import com.example.my_vk_client.App
import com.example.my_vk_client.dagger.module.AppModule
import com.example.my_vk_client.dagger.module.DataModule
import com.example.my_vk_client.dagger.module.NavigationModule
import com.example.my_vk_client.dagger.module.PresentationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    PresentationModule::class,
    DataModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<App>


}