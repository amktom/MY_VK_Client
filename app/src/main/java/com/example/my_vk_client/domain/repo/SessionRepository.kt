package com.example.my_vk_client.domain.repo

import com.example.my_vk_client.domain.repo.entity.User
import io.reactivex.Single

interface SessionRepository {

    fun login(phone: String, password: String): Single<User>

    fun isAuth(): Boolean

}