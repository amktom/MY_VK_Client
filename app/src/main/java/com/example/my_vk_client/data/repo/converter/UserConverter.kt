package com.example.my_vk_client.data.repo.converter

import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.data.repo.response.ProfileResponse
import javax.inject.Inject

class UserConverter @Inject constructor(): DataConverter<ProfileResponse, User> {

    override fun convert(t: ProfileResponse): User = User (
        t.id,
        t.firstName,
        t.lastName,
        t.avatar,
        t.friends,
        t.city,
        t.birthday,
        t.phone,
        t.status
    )
}