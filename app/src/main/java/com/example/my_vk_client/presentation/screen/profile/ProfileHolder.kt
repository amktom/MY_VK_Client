package com.example.my_vk_client.presentation.screen.profile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.screen.extensions.loadCircleImage
import kotlinx.android.synthetic.main.wall_items_profile.view.*

class ProfileHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(profile: Profile) {
        itemView.profileImage.loadCircleImage(profile.avatarUrl)
        itemView.profileName.text = profile.lastName + " " + profile.firstName
        itemView.profileStatusTextView.text = profile.status
        itemView.friendsCountView.text = profile.friends
        itemView.townView.text = profile.homeTown
        itemView.birthdayView.text = profile.birthDate
        itemView.phoneView.text = profile.phone
    }
}