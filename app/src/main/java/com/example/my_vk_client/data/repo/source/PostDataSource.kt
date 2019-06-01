package com.example.my_vk_client.data.repo.source

import com.example.my_vk_client.dagger.MockQualifier
import com.example.my_vk_client.network.Api
import com.example.my_vk_client.response.PostResponse
import io.reactivex.Single
import javax.inject.Inject

interface PostDataSource {

    fun getPosts(id: Long, page: Int): Single<PostResponse>
}

class PostDataSourceImpl @Inject constructor(@MockQualifier private val api: Api) : PostDataSource {

    override fun getPosts(id: Long, page: Int): Single<PostResponse> =
        api.getPosts(id, page)

}