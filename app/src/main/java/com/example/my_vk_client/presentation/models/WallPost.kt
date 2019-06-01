package com.example.my_vk_client.presentation.models

class WallPost (
        id: Long,
        val message: String,
        val postContent: List<PostContent>
) : WallItem(id)