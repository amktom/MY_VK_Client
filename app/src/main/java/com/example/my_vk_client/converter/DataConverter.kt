package com.example.my_vk_client.converter

interface DataConverter<T, K> {

    fun convert(t: T): K
}