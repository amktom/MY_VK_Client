package com.example.my_vk_client.data.repo.request

import com.google.gson.annotations.SerializedName

class LoginRequest (
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String
)