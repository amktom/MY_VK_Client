package com.example.my_vk_client.presentation.screen.profile

import android.provider.ContactsContract
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vk_client.presentation.models.Profile
import kotlinx.android.synthetic.main.wall_items_profile.view.*

class ProfileHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(profile: Profile) {
        itemView.profileStatusTextView.text = profile.status
        itemView.townView.text = profile.homeTown
        itemView.birthdayView.text = profile.birthDate
        itemView.phoneView.text = profile.phone
    }
}