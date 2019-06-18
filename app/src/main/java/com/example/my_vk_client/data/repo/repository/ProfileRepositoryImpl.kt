package com.example.my_vk_client.data.repo.repository

import com.example.my_vk_client.data.repo.source.ProfileSource
import com.example.my_vk_client.domain.repo.repository.ProfileRepository
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.data.repo.converter.DataConverter
import com.example.my_vk_client.data.repo.response.ProfileResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileSource,
    private val userConverter: DataConverter<ProfileResponse, User>
) : ProfileRepository {

    override fun saveProfile(user: User): Single<User> =
        profileDataSource.getProfile()
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)

    override fun getProfile(): Single<User> =
        profileDataSource.getProfile()
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)
}