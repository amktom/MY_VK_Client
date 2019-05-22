package com.example.my_vk_client.domain.repo

import com.example.my_vk_client.presentation.models.Profile

interface ProfileRepository {

    fun getProfile(): Profile
}