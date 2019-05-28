package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.converter.DataConverter
import com.example.my_vk_client.domain.repo.PostRepository
import com.example.my_vk_client.domain.repo.ProfileRepository
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.models.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val router: Router,
    private val profileRepository: ProfileRepository,
    private val profileConverter: DataConverter<User, Profile>,
    private val postRepository: PostRepository
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        getProfile()
    }

    fun logout() {
        TODO("Navigate to login")
    }

    private fun getProfile() {
        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showProfile(profileConverter.convert(it))
            }, {
                viewState.showNetworkError()
            }).untilDestroy()
    }
}