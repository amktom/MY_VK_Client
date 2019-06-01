package com.example.my_vk_client.data.repo

import com.example.my_vk_client.data.repo.source.ProfileSource
import com.example.my_vk_client.domain.repo.ProfileRepository
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.converter.DataConverter
import com.example.my_vk_client.response.ProfileResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileSource,
    private val userConverter: DataConverter<ProfileResponse, User>
) : ProfileRepository {

    override fun getProfile(): Single<User> =
        profileDataSource.getProfile()
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)
}