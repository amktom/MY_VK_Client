package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.MvpView

interface ProfileView : MvpView {
    fun showProfile(firstName: String)
    fun showFeed()
}