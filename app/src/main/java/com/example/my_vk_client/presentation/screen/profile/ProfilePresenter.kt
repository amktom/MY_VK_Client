package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.domain.repo.ProfileRepository
import com.example.my_vk_client.presentation.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val router: Router,
    private val profileRepository: ProfileRepository
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        setData()
    }

    fun logout() {
        TODO("Navigate to login")
    }

    private fun setData(){
        viewState.showProfile(profileRepository.getProfile())
    }
}