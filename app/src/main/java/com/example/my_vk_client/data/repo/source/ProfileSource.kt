package com.example.my_vk_client.data.repo.source

import com.example.my_vk_client.dagger.MockQualifier
import com.example.my_vk_client.network.Api
import com.example.my_vk_client.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

interface ProfileSource {

    fun getProfile(): Single<ProfileResponse>

}

class ProfileSourceImpl @Inject constructor(@MockQualifier private val api: Api) : ProfileSource {
    override fun getProfile(): Single<ProfileResponse> = api.getProfile(132089045)
}