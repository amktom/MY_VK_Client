package com.example.my_vk_client.data.repo.network

import com.example.my_vk_client.data.repo.request.LoginRequest
import com.example.my_vk_client.data.repo.response.PostResponse
import com.example.my_vk_client.data.repo.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.*

interface Api {

    @POST("auth")
    fun login(@Body login: LoginRequest): Single<ProfileResponse>

    @GET("{user_id}/profile")
    fun getProfile(@Path("user_id") userId: Long): Single<ProfileResponse>

    @GET("{user_id}/posts/page/{page}")
    fun getPosts(@Path("user_id") userId: Long, @Path("page") page: Int): Single<PostResponse>



}


