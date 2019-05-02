package com.example.my_vk_client.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.my_vk_client.R

class ProfileFragment : BaseFragment(R.layout.profile_layout), ProfileView {
    override fun showProfile(firstName: String) {
        TODO("show profile fields")
    }

    override fun showFeed() {
        TODO("magic")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initToolbar()
//        initFeed()
    }



    private fun initToolbar() {
        TODO("initialise ToolBar")
    }

    private fun initFeed() {
        TODO("show Feed")
        showFeed()
    }
}