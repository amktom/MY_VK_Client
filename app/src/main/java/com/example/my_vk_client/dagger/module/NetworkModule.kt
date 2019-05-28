package com.example.my_vk_client.dagger.module

import com.example.my_vk_client.dagger.LiveQualifier
import com.example.my_vk_client.dagger.MockQualifier
import com.example.my_vk_client.network.Api
import com.example.my_vk_client.network.ApiMock
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
abstract class NetworkModule {

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideOkHttp() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor {
                Timber.tag("OkHttp").d(it)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

        @JvmStatic
        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl("http://api.myvk.com/")
            .build()

        @JvmStatic
        @Singleton
        @Provides
        @LiveQualifier
        fun  provideApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
    }

    @Singleton
    @Binds
    @MockQualifier
    abstract fun bindMockApi(instant: ApiMock): Api
}