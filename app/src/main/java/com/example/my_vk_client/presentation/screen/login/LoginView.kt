package com.example.my_vk_client.presentation.screen.login

import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun showPhoneError()
    fun showPasswordError()
    fun showAuthError()
    fun showNetworkError()
    fun showProgress()
    fun hideProgress()
}