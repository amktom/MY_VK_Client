package com.example.my_vk_client.data.repo

import com.example.my_vk_client.domain.repo.PostRepository
import com.example.my_vk_client.presentation.models.WallPost
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(): PostRepository {
    override fun getAll(): List<WallPost>  = (1..5).map {
        listOf(
                WallPost(
                        it,
                        "Sample"
                ),
                WallPost(
                        it,
                        "LOOOL"
                ),

                WallPost(
                        it,
                        "Keeek"
                ),

                WallPost(
                        it,
                        "Cheburek"
                ),

                WallPost(
                        it,
                        "Android"
                )
        )
    }.flatten()
}