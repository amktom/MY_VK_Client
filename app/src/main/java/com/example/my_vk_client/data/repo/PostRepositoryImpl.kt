package com.example.my_vk_client.data.repo

import com.example.my_vk_client.domain.repo.PostRepository
import com.example.my_vk_client.presentation.models.PostContent
import com.example.my_vk_client.presentation.models.WallPost
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor() : PostRepository {
    override fun getAll(): List<WallPost> = (1..5).map {
        WallPost(
            it,
            "Sample",
            listOf(
                PostContent(
                    PostContent.PHOTO,
                    "https://picsum.photos/id/$it/200/300"
                )
            )
        )
    }
}