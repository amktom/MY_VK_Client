package com.example.my_vk_client.presentation.screen.profile

import android.os.Bundle
import android.view.View
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.common.BaseFragment
import com.example.my_vk_client.presentation.models.Profile

class ProfileFragment : BaseFragment(R.layout.profile_layout), ProfileView {

    lateinit var presenter: ProfilePresenter

    private val feedAdapter = FeedAdapter()

    override fun showProfile(profile: Profile) {
        feedAdapter.setProfile(profile)
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