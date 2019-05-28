package com.example.my_vk_client.network

import com.example.my_vk_client.request.LoginRequest
import com.example.my_vk_client.response.ProfileResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiMock @Inject constructor() : Api {

    override fun login(login: LoginRequest): Single<ProfileResponse> =
        if (login.phone == "+7(960)976-12-09" && login.password == "abcd") {
            Single.just(
                ProfileResponse(
                    132089045,
                    "Андрей",
                    "Морозов",
                    "https://picsum.photos/200/300",
                    "162",
                    "27.03.1997",
                    "Томск",
                    "+7(960)976-12-09",
                    "текущий статус"
                )
            )
        } else {
            Single.error(RuntimeException("User not Found"))
        }.delay(1500, TimeUnit.MILLISECONDS)

    override fun getProfile(userId: Long): Single<ProfileResponse> =
        Single.just(
            ProfileResponse(
                132089045,
                "Андрей",
                "Морозов",
                "https://picsum.photos/200/300",
                "162",
                "27.03.1997",
                "Томск",
                "+7(960)976-12-09",
                "текущий статус"
            )
        ).delay(2, TimeUnit.SECONDS)
}