package com.example.my_vk_client.presentation.screen.login

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.common.BaseFragment
import com.example.my_vk_client.presentation.screen.extensions.showSnackbar
import kotlinx.android.synthetic.main.login_layout.*
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.login_layout), LoginView {

    companion object {
        fun createInstance() = LoginFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAuthButtonOnClickListner()
    }

    private fun setAuthButtonOnClickListner() {
        btnAuth.setOnClickListener {
            val phone = loginEditText.text.toString()
            val password = passwordEditText.text.toString()
            presenter.loginUser(phone, password)
        }
    }

    override fun showPhoneError() {
        loginEditText.requestFocus()
        loginTextLayout.error = "Phone number is incorrect"
    }

    override fun showPasswordError() {
        passwordEditText.requestFocus()
        passwordTextLayout.error = "Password is incorrect"
    }

    override fun showAuthError() {
        btnAuth.showSnackbar("Something was wrong")
    }

    override fun showNetworkError() {
        btnAuth.showSnackbar("Network error")
    }

    override fun showProgress() {
        authProgressBar.show()
        btnAuth.isEnabled = false
    }

    override fun hideProgress() {
        authProgressBar.hide()
        btnAuth.isEnabled = true
    }
}