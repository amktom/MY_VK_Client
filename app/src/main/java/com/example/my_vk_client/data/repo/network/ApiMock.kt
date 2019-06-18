package com.example.my_vk_client.data.repo.network

import com.example.my_vk_client.data.repo.request.LoginRequest
import com.example.my_vk_client.data.repo.response.Content
import com.example.my_vk_client.data.repo.response.Post
import com.example.my_vk_client.data.repo.response.PostResponse
import com.example.my_vk_client.data.repo.response.ProfileResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiMock @Inject constructor() : Api {

    override fun login(login: LoginRequest): Single<ProfileResponse> =
        if (login.phone == "+79609761209" && login.password == "abcd") {
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

    override fun getPosts(userId: Long, page: Int): Single<PostResponse> =
        Single.just(
            PostResponse((0L..4L).map {
                listOf(
                    Post(
                        it,
                        "Sample",
                        listOf(
                            Content(
                                Content.PHOTO,
                                "https://pp.userapi.com/c633816/v633816488/2ba2/wEXKKBnrhuI.jpg"
                            ),
                            Content(
                                Content.PHOTO,
                                "https://picsum.photos/200/300"
                            )
                        )

                    ),
                    Post(
                        it,
                        "Sample",
                        listOf(
                            Content(
                                Content.PHOTO,
                                "https://pp.userapi.com/c633816/v633816488/2ba2/wEXKKBnrhuI.jpg"
                            ),
                            Content(
                                Content.PHOTO,
                                "https://picsum.photos/200/300"
                            )
                        )

                    ),
                    Post(
                        it,
                        "Sample",
                        listOf(
                            Content(
                                Content.PHOTO,
                                "https://pp.userapi.com/c633816/v633816488/2ba2/wEXKKBnrhuI.jpg"
                            ),
                            Content(
                                Content.PHOTO,
                                "https://picsum.photos/200/300"
                            )
                        )
                    )
                )
            }.flatten())
        )
            .delay(2, TimeUnit.SECONDS)
    
}