package com.example.my_vk_client.data.repo.converter

interface DataConverter<T, K> {

    fun convert(t: T): K
}