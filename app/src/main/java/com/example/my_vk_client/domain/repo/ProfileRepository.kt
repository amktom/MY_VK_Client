package com.example.my_vk_client.domain.repo

import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.models.Profile
import io.reactivex.Single

interface ProfileRepository {

    fun getProfile(): Single<User>
}