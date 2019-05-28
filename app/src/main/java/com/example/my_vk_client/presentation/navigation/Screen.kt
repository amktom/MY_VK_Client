package com.example.my_vk_client.presentation.navigation

import androidx.fragment.app.Fragment
import com.example.my_vk_client.presentation.screen.login.LoginFragment
import com.example.my_vk_client.presentation.screen.profile.ProfileFragment
import com.example.my_vk_client.presentation.screen.splash.SplashFragment

import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class SplashScreen : Screen(SplashFragment.createInstance())
    class LoginScreen : Screen(LoginFragment.createInstance())
    class ProfileScreen : Screen(ProfileFragment.createInstance())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}
