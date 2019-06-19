package com.example.my_vk_client.presentation.screen.editprofile

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.domain.repo.repository.ProfileRepository
import com.example.my_vk_client.domain.repo.repository.SessionRepository
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.converter.ProfileConverter
import com.example.my_vk_client.presentation.models.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class EditProfilePresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository,
    private val profileRepository: ProfileRepository,
    private val profileConverter: ProfileConverter
) : BasePresenter<EditProfileView>() {

    var avatarUrl = ""

    override fun onFirstViewAttach() {
        getProfile()
    }

    private fun getProfile() {
        viewState.showProgress()
        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally(viewState::hideProgress)
            .subscribe({
                val profile = profileConverter.convert(it)
                avatarUrl = profile.avatarUrl

                viewState.setProfile(profile)

            }, {
                viewState.showNetworkError()
            })
            .untilDestroy()
    }

    fun saveProfile(profile: Profile) {
        saveProfileToRepository(profile)
    }

    private fun saveProfileToRepository(profile: Profile) {
        viewState.showProgress()
        profile.avatarUrl = avatarUrl
        profileRepository.saveProfile(profileConverter.convertFrom(profile))
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally(viewState::hideProgress)
            .subscribe({
                router.exit()
            }, {
                viewState.showNetworkError()
            })
            .untilDestroy()
    }

    fun onBackClicked() {
        router.exit()
    }
}