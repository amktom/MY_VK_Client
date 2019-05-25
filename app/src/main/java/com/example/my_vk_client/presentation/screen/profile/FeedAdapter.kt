package com.example.my_vk_client.presentation.screen.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vk_client.R
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.models.WallItem
import com.example.my_vk_client.presentation.models.WallPost

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<WallItem> = mutableListOf()
    private val PROFILE = 1
    private val POST = 2

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProfileHolder -> holder.bind(items[position] as Profile)
            is PostHolder -> holder.bind(items[position] as WallPost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        PROFILE -> ProfileHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.wall_items_profile, parent, false)
        )
        POST -> PostHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_layout, parent, false)
        )

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

    fun setPosts(posts: List<WallItem>) {
        val profile = items[0]
        items.clear()
        items.add(profile)
        items.addAll(posts)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) PROFILE else POST
    }
}