package com.example.my_vk_client.presentation.screen.login

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.common.BaseFragment
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.login_layout), LoginView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = presenter

}