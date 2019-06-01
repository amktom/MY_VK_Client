package com.example.my_vk_client.domain.repo

import com.example.my_vk_client.domain.repo.entity.Post
import io.reactivex.Single

interface PostRepository {

    fun getPosts(page: Int): Single<List<Post>>
}