package com.example.my_vk_client.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.my_vk_client.App
import com.example.my_vk_client.R
import kotlinx.android.synthetic.main.login_layout.*
import com.example.my_vk_client.navigation.Screen

class LoginFragment : BaseFragment(R.layout.login_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar!!.hide()
        btnAuth.setOnClickListener {App.INCTANCE.router.navigateTo(Screen.ProfileScreen())}
    }
}