package com.example.my_vk_client.data.repo.source

import android.content.SharedPreferences
import javax.inject.Inject

interface SessionSource {

    fun setToken(token: String)

    fun clearToken()

    fun getToken(): String
}

class SessionSourceImpl @Inject constructor(
    private val sharedPreference: SharedPreferences
) : SessionSource {

    private companion object{
        const val TOKEN = "authToken"
    }

    override fun setToken(token: String) = sharedPreference.edit()
        .putString(TOKEN, token)
        .apply()

    override fun clearToken() = sharedPreference.edit()
        .remove(TOKEN)
        .apply()

    override fun getToken(): String = sharedPreference.getString(TOKEN, "").orEmpty()
}