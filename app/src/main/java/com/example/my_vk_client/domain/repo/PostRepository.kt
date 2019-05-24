package com.example.my_vk_client.domain.repo

import com.example.my_vk_client.presentation.models.WallPost

interface PostRepository {

    fun getAll(): List<WallPost>
}