package com.example.my_vk_client.presentation.screen.editprofile

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.common.BaseFragment
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.screen.extensions.loadCircleImage
import com.example.my_vk_client.presentation.screen.extensions.showSnackbar
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import javax.inject.Inject

class EditProfileFragment : BaseFragment(R.layout.fragment_edit_profile), EditProfileView {
    override fun setProfile(profile: Profile) {
        editFirstName.setText(profile.firstName)
        editLastName.setText(profile.lastName)
        profileStatusEditTextView.setText(profile.status)
        townEditView.setText(profile.homeTown)
        birthdayEditView.setText(profile.birthDate)
        profileEditImageView.loadCircleImage(profile.avatarUrl)
    }

    override fun setAvatar(path: String) {
        profileEditImageView.loadCircleImage(path)
    }

    override fun showProgress() {
        editProgressbar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        editProgressbar.visibility = View.INVISIBLE
    }

    override fun showNetworkError() {
        editProgressbar.showSnackbar("Network error, try again later")

    }

    companion object {
        fun createInstance() = EditProfileFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: EditProfilePresenter

    @ProvidePresenter
    fun providePresenter(): EditProfilePresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initToolBar() {
        editProfileToolbar.inflateMenu((R.menu.menu_profile))
        editProfileToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.save_profile) {
                val profile = Profile(
                    0,
                    editFirstName.text.toString(),
                    editLastName.text.toString(),
                    "",
                    friendsCountEditView.text.toString(),
                    townEditView.text.toString(),
                    birthdayEditView.text.toString(),
                    phoneEditView.text.toString(),
                    profileStatusEditTextView.text.toString()
                )
                presenter.saveProfile(profile)
            }
            true
        }
        editProfileToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        editProfileToolbar.setNavigationOnClickListener {
            presenter.onBackClicked()
        }
    }


}