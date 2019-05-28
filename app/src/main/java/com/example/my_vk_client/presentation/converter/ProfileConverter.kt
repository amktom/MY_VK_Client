package com.example.my_vk_client.presentation.converter

import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.models.Profile
import javax.inject.Inject

class ProfileConverter @Inject constructor() : PresentationConverter<User, Profile> {

    override fun convert(t: User): Profile =
        Profile(
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