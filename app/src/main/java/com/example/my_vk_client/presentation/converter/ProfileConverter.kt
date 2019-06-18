package com.example.my_vk_client.presentation.converter

import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.presentation.models.Profile
import javax.inject.Inject

class ProfileConverter @Inject constructor() : TwoWayConverter<User, Profile> {

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

    override fun convertFrom(k: Profile): User =
        User(
            k.id,
            k.firstName,
            k.lastName,
            k.friends,
            k.status,
            k.avatarUrl,
            k.birthDate,
            k.homeTown,
            k.phone
        )
}