package com.example.my_vk_client.data.repo.source

import com.example.my_vk_client.dagger.MockQualifier
import com.example.my_vk_client.network.Api
import com.example.my_vk_client.request.LoginRequest
import com.example.my_vk_client.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface AuthSource {

    fun login(phone: String, password: String): Single<ProfileResponse>
}

class AuthSourceImpl @Inject constructor(@MockQualifier private val api: Api) : AuthSource {
    override fun login(phone: String, password: String): Single<ProfileResponse> =
        api.login(LoginRequest(
            phone,
            password
        ))
}