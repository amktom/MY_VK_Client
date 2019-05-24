package com.example.my_vk_client.presentation.screen.profile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vk_client.presentation.models.WallPost
import kotlinx.android.synthetic.main.post_layout.view.*

class PostHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(data: WallPost) {
        if(data.message.isNotEmpty()) {
            itemView.postMessageTextView.visibility = View.VISIBLE
            itemView.postMessageTextView.text = data.message
        }
    }
}