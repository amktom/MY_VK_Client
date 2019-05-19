package com.example.my_vk_client.dagger

import com.example.my_vk_client.presentation.screen.login.LoginFragment
import com.example.my_vk_client.presentation.screen.profile.ProfileFragment
import com.example.my_vk_client.presentation.screen.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileFragment(): ProfileFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginFragment

}