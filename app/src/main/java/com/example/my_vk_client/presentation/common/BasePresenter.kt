package com.example.my_vk_client.presentation.common

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {
}