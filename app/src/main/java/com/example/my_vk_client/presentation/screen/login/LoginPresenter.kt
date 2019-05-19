package com.example.my_vk_client.presentation.screen.login

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.presentation.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(private val router: Router) : BasePresenter<LoginView>() {
}
