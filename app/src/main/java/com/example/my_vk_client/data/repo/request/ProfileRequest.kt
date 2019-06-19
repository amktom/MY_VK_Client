package com.example.my_vk_client.data.repo.request

import com.google.gson.annotations.SerializedName

class ProfileRequest (
    @SerializedName("id") val userId: Long,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("avatarUrl") val avatarUrl: String,
    @SerializedName("homeTown") val homeTown: String,
    @SerializedName("birthDate") val birthDate: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("status") val status: String
)