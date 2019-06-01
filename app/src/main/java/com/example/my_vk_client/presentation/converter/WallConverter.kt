package com.example.my_vk_client.presentation.converter

import com.example.my_vk_client.domain.repo.entity.Post
import com.example.my_vk_client.presentation.models.PostContent
import com.example.my_vk_client.presentation.models.WallPost
import com.example.my_vk_client.response.Content
import javax.inject.Inject

class WallConverter @Inject constructor() :
    PresentationConverter<Post, WallPost> {

    override fun convert(t: Post): WallPost =
            WallPost(
                t.id,
                t.message,
                t.contents.map {
                    PostContent(
                        it.type,
                        it.url
                    )
                }
            )
}