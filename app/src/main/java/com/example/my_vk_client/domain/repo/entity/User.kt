package com.example.my_vk_client.domain.repo.entity

data class User (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val friends: String,
    val status: String,
    val avatar: String,
    val birthday: String,
    val city: String,
    val phone: String
)