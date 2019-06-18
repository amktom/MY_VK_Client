package com.example.my_vk_client.data.repo.response

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("posts") val posts: List<Post>
)

class Post(
    @SerializedName("id") val postId: Long,
    @SerializedName("message") val message: String,
    @SerializedName("content") val content: List<Content>
)

class Content(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    companion object {
        const val PHOTO = "photo"
    }
}