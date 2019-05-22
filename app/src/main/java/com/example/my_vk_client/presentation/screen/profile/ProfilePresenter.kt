package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.presentation.common.BasePresenter
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor() : BasePresenter<ProfileView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun logout() {
        TODO("Navigate to login")
    }
}