package com.example.my_vk_client.navigation

import androidx.fragment.app.Fragment
import com.example.my_vk_client.fragment.Splash

import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class SplashScreen : Screen(Splash())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}
