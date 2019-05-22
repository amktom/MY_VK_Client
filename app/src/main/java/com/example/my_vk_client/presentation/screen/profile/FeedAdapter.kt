package com.example.my_vk_client.presentation.screen.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.models.WallItem

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<WallItem> = mutableListOf()
    private val PROFILE = 1

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProfileHolder -> holder.bind(items[position] as Profile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
       PROFILE ->
           ProfileHolder(LayoutInflater.from(parent.context).inflate(R.layout.wall_items_profile, parent, false))
        else -> throw IllegalArgumentException("viewType $viewType not found")
    }

    fun setProfile(profile: Profile) {
        if (items.isEmpty()) {
            items.add(profile)
        } else {
            this.items[0] = profile
        }
        notifyItemChanged(0)
    }
}