package com.example.my_vk_client.presentation.screen.login

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.domain.repo.SessionRepository
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository
) : BasePresenter<LoginView>() {

    fun loginUser(phone: String, password: String) {
        viewState.showProgress()
        sessionRepository
            .login(phone, password)
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { viewState.hideProgress() }
            .subscribe(
                {
                    router.newRootScreen(Screen.ProfileScreen())
                },
                {
                    viewState.showAuthError()
                }).untilDestroy()
    }

}
