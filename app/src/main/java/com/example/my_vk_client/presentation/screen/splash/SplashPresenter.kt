package com.example.my_vk_client.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.domain.repo.SessionRepository
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.navigation.Screen

import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class SplashPresenter @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val router: Router
) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(
                if (sessionRepository.isAuth()) {
                    Screen.ProfileScreen()
                } else {
                    Screen.LoginScreen()
                }
            )
        }, 2000)
    }
}