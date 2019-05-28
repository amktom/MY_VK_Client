package com.example.my_vk_client.presentation.screen.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.common.BaseFragment
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.models.WallPost
import kotlinx.android.synthetic.main.profile_layout.*
import javax.inject.Inject

class ProfileFragment : BaseFragment(R.layout.profile_layout), ProfileView {

    companion object {
        fun createInstance() = ProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    private val feedAdapter = FeedAdapter()

    @ProvidePresenter
    fun providePresenter(): ProfilePresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initToolbar()
        initFeed()
    }

    override fun showProfile(profile: Profile) {
        feedAdapter.setProfile(profile)
    }

    override fun showFeed(posts: List<WallPost>) {
        feedAdapter.setPosts(posts)
    }


    private fun initToolbar() {
        TODO("initialise ToolBar")
    }

    private fun initFeed() {
        feed.layoutManager = LinearLayoutManager(context)
        feed.adapter = feedAdapter
    }
}