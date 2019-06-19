package com.example.my_vk_client.data.repo.network

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.my_vk_client.data.repo.request.LoginRequest
import com.example.my_vk_client.data.repo.request.ProfileRequest
import com.example.my_vk_client.data.repo.response.Content
import com.example.my_vk_client.data.repo.response.Post
import com.example.my_vk_client.data.repo.response.PostResponse
import com.example.my_vk_client.data.repo.response.ProfileResponse
import com.google.gson.Gson
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val PROFILE = "profile"

class ApiMock @Inject constructor(private val sharedPreferences: SharedPreferences) : Api {

    override fun login(login: LoginRequest): Single<ProfileResponse> =
        if (login.phone == "+79609761209" && login.password == "abcd") {
            if (!sharedPreferences.contains(PROFILE)) {
                val profile = ProfileResponse(
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

                sharedPreferences.edit {
                    putString(PROFILE, Gson().toJson(profile))
                }
            }

            getProfile(132089045)

        } else {
            Single.error(RuntimeException("User not Found"))
        }
            .delay(1500, TimeUnit.MILLISECONDS)

    override fun getProfile(userId: Long): Single<ProfileResponse> {
        val profileJson = sharedPreferences.getString(PROFILE, "").orEmpty()
        return if (profileJson.isNotEmpty()) {
            Single.just(Gson().fromJson(profileJson, ProfileResponse::class.java))
                .delay(2, TimeUnit.SECONDS)
        } else {
            Single.error(java.lang.RuntimeException("User not found"))
        }
    }

    override fun saveProfile(id: Long, profileRequest: ProfileRequest): Single<ProfileResponse> {
        sharedPreferences.edit {
            putString(PROFILE, Gson().toJson(profileRequest))
        }

        return getProfile(id)
    }

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
            .delay(3, TimeUnit.SECONDS)

}