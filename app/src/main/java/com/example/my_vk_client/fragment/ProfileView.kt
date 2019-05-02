package com.example.my_vk_client.fragment

import com.arellomobile.mvp.MvpView

interface ProfileView : MvpView {
    fun showProfile(firstName: String)
    fun showFeed()
}