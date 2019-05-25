package com.example.my_vk_client.presentation.screen.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadCircleImage(url: String) {
    Glide.with(context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}

fun ImageView.load(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}