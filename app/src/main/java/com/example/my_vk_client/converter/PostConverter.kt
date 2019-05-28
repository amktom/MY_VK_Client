package com.example.my_vk_client.converter

import com.example.my_vk_client.domain.repo.entity.Post
import com.example.my_vk_client.response.PostResponse
import javax.inject.Inject

class PostsConverter @Inject constructor() :
    DataConverter<@JvmSuppressWildcards PostResponse, List<@JvmSuppressWildcards Post>> {

    override fun convert(t: PostResponse): List<Post> = t.posts.map {
        Post(
            it.postId,
            it.message,
            it.content.map { contentResponse ->
                Post.PostContent(
                    contentResponse.type,
                    contentResponse.url
                )
            }
        )
    }
}