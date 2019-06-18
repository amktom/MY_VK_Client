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
import com.example.my_vk_client.presentation.screen.extensions.showSnackbar
import kotlinx.android.synthetic.main.profile_layout.*
import javax.inject.Inject

class ProfileFragment : BaseFragment(R.layout.profile_layout), ProfileView {

    companion object {
        fun createInstance() = ProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    private val feedAdapter = FeedAdapter { presenter.loadPosts() }

    @ProvidePresenter
    fun providePresenter(): ProfilePresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()

        profileRefreshLayout.setOnRefreshListener(presenter::refreshPosts)
    }

    override fun showProfile(profile: Profile) {
        feedAdapter.setProfile(profile)
    }

    override fun showFeed(posts: List<WallPost>) {
        feedAdapter.setPosts(posts)
    }


    private fun initToolbar() {
        profileToolbar.inflateMenu(R.menu.menu_profile)
        profileToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.edit_profile) {
                presenter.onEditProfileClicked()
            }
            true
        }
    }

    private fun initFeed() {
        feed.layoutManager = LinearLayoutManager(context)
        feed.adapter = feedAdapter
    }

    override fun showNetworkError() {
        feed.showSnackbar("Network error")
    }

    override fun showProgress() {
        profileRefreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        profileRefreshLayout.isRefreshing = false
    }

}