package com.example.my_vk_client.presentation.models

data class PostContent(
    val type: String,
    val url: String
) {
    companion object {
        const val PHOTO = "photo"
        const val VIDEO = "video"
        const val AUDIO = "audio"
    }
}