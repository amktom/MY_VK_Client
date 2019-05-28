package com.example.my_vk_client.presentation.screen.extensions

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar

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

fun View.showSnackbar(
    string: String,
    @ColorInt colorId: Int = Color.WHITE,
    length: Int = Snackbar.LENGTH_LONG
) {
    val snack = Snackbar.make(this, string, length)
    val tv = snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(colorId)
    snack.show()
}