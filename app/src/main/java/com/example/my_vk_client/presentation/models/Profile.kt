package com.example.my_vk_client.presentation.models

class Profile (
    id: Int,
    val firstName: String,
    val lastName: String,
    val avatarUrl: String,
    val homeTown: String,
    val birthDate: String,
    val phone: String,
    val status: String
) : WallItem(id)