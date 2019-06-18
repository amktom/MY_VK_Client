package com.example.my_vk_client.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.example.my_vk_client.domain.repo.repository.PostRepository
import com.example.my_vk_client.domain.repo.repository.ProfileRepository
import com.example.my_vk_client.domain.repo.entity.Post
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.common.BasePresenter
import com.example.my_vk_client.presentation.common.Paginator
import com.example.my_vk_client.presentation.converter.PresentationConverter
import com.example.my_vk_client.presentation.converter.TwoWayConverter
import com.example.my_vk_client.presentation.converter.WallConverter
import com.example.my_vk_client.presentation.models.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val router: Router,
    private val profileRepository: ProfileRepository,
    private val wallConverter: WallConverter,
    private val profileConverter: TwoWayConverter<User, Profile>,
    private val postRepository: PostRepository
) : BasePresenter<ProfileView>() {

    private val paginator = Paginator(
        {
            postRepository.getPosts(it)
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
        },
        object : Paginator.ViewController<Post> {
            override fun showEmptyProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
                viewState.showNetworkError()
            }

            override fun showEmptyView(show: Boolean) {

            }

            override fun showData(show: Boolean, data: List<Post>) {
                viewState.showFeed(
                    data.map { wallConverter.convert(it) }
                )
            }

            override fun showErrorMessage(error: Throwable) {
                viewState.showNetworkError()
            }

            override fun showRefreshProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showPageProgress(show: Boolean) {
                viewState.showProgress()
            }
        }
    )

    override fun onFirstViewAttach() {
        paginator.refresh()
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

    fun loadPosts() {
        paginator.loadNewPage()
    }

    fun refreshPosts() {
        paginator.refresh()
    }

    fun onEditProfileClicked() {
        router.navigateTo(com.example.my_vk_client.presentation.navigation.Screen.EditProfileScreen())
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }
}