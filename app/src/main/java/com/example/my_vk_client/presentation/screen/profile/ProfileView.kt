package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import com.example.my_vk_client.presentation.models.Profile

interface ProfileView : MvpView {
    fun showProfile(profile: Profile)
    fun showFeed()
}