package com.example.my_vk_client.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject


@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : BasePresenter<MainVew>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screen.SplashScreen())
    }
}