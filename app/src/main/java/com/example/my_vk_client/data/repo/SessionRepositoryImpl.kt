package com.example.my_vk_client.data.repo

import com.example.my_vk_client.domain.repo.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    override fun isAuth(): Boolean = true

}