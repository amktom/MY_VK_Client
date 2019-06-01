package com.example.my_vk_client.dagger.module

import com.example.my_vk_client.converter.DataConverter
import com.example.my_vk_client.converter.PostsConverter
import com.example.my_vk_client.converter.UserConverter
import com.example.my_vk_client.domain.repo.entity.Post
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.converter.PresentationConverter
import com.example.my_vk_client.presentation.converter.ProfileConverter
import com.example.my_vk_client.presentation.converter.WallConverter
import com.example.my_vk_client.presentation.models.Profile
import com.example.my_vk_client.presentation.models.WallPost
import com.example.my_vk_client.response.PostResponse
import com.example.my_vk_client.response.ProfileResponse
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): DataConverter<ProfileResponse, User>

    @Reusable
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): PresentationConverter<User, Profile>

    @Reusable
    @Binds
    fun bindPostConverter(instance: PostsConverter): DataConverter<PostResponse, List<Post>>

    @Reusable
    @Binds
    fun bindWallConverter(instance: WallConverter): PresentationConverter<Post, WallPost>
}