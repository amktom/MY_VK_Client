package com.example.my_vk_client.presentation.converter

interface PresentationConverter<T, K> {

    fun convert(t: T): K
}