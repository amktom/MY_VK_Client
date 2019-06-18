package com.example.my_vk_client.presentation.converter

interface TwoWayConverter<T, K> {
    fun convert(t: T): K

    fun convertFrom(k: K): T
}