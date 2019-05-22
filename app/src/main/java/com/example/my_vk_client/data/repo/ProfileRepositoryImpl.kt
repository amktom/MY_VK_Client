package com.example.my_vk_client.data.repo

import com.example.my_vk_client.domain.repo.ProfileRepository
import com.example.my_vk_client.presentation.models.Profile
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {
    override fun getProfile(): Profile  = Profile(
        132089045,
        "Андрей",
        "Морозов",
        "https://yadi.sk/i/dcGlr8synFiLWQ",
        "Томск",
        "27.03.1997",
        "+7(960)976-12-09",
        "текущий статус"
    )
}