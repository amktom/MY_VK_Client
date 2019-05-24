package com.example.my_vk_client.data.repo

import com.example.my_vk_client.domain.repo.PostRepository
import com.example.my_vk_client.presentation.models.PostContent
import com.example.my_vk_client.presentation.models.WallPost
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor() : PostRepository {
    override fun getAll(): List<WallPost> = (1..5).map {
        listOf(
            WallPost(
                it,
                "Sample",
                listOf(
                    PostContent(
                        PostContent.PHOTO,
                        "https://picsum.photos/200/300"
                    )
                )
            ),
            WallPost(
                it,
                "LOOOL",
                listOf(
                    PostContent(
                        PostContent.PHOTO,
                        "https://picsum.photos/200/300"
                    )
                )
            ),

            WallPost(
                it,
                "Keeek",
                listOf(
                    PostContent(
                        PostContent.PHOTO,
                        "https://picsum.photos/200/300"
                    )
                )
            ),

            WallPost(
                it,
                "Cheburek",
                listOf(
                    PostContent(
                        PostContent.PHOTO,
                        "https://picsum.photos/200/300"
                    )
                )
            ),

            WallPost(
                it,
                "Android",
                listOf(
                    PostContent(
                        PostContent.PHOTO,
                        "https://picsum.photos/200/300"
                    )
                )
            )
        )
    }.flatten()
}