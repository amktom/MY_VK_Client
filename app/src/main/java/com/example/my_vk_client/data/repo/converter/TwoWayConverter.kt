package com.example.my_vk_client.data.repo.converter

interface TwoWayConverter<T, K> {

    fun convertTo(t: T): K

    fun convertFrom(k: K): T
}