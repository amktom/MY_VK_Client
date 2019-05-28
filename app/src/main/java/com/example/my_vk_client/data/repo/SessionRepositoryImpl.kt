package com.example.my_vk_client.data.repo

import com.example.my_vk_client.converter.DataConverter
import com.example.my_vk_client.data.repo.source.AuthSource
import com.example.my_vk_client.data.repo.source.SessionSource
import com.example.my_vk_client.domain.repo.SessionRepository
import com.example.my_vk_client.domain.repo.entity.User
import com.example.my_vk_client.response.ProfileResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val authDataSource: AuthSource,
    private val sessionDataSource: SessionSource,
    private val userConverter: DataConverter<ProfileResponse, User>
) : SessionRepository {

    override fun login(phone: String, password: String): Single<User> =
        authDataSource.login(phone, password)
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)

    override fun isAuth(): Boolean = sessionDataSource.getToken().isNotEmpty()

}
