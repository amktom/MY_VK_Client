package com.example.my_vk_client.presentation.screen.editprofile

import com.arellomobile.mvp.MvpView
import com.example.my_vk_client.presentation.models.Profile

interface EditProfileView : MvpView {
    fun setProfile(profile: Profile)
    fun setAvatar(path: String)
    fun showProgress()
    fun hideProgress()
    fun showNetworkError()

}