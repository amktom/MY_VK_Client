package com.example.my_vk_client.fragment

import com.example.my_vk_client.App
import com.example.my_vk_client.R
import com.example.my_vk_client.navigation.Screen
import kotlinx.android.synthetic.main.fragment_splash.*

class Splash : BaseFragment(R.layout.fragment_splash) {

    override fun onResume() {
        super.onResume()

        asd.postDelayed({
            App.INCTANCE.router.replaceScreen(Screen.LoginScreen())
        }, 3000)

    }
}