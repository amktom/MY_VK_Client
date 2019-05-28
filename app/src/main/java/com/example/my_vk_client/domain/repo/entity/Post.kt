package com.example.my_vk_client.domain.repo.entity

class Post(
    val id: Long,
    val message: String,
    val contents: List<PostContent>
)

data class PostContent(
    val type: String,
    val url: String
)