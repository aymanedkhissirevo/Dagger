package com.example.dagger.di.modules

import com.example.dagger.remote.AppApi
import com.example.dagger.repositories.ApiRepository
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class DataModule {


    @Singleton
    @Provides
    fun okHTPP(): OkHttpClient.Builder {
        return OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    fun providesRemoteService(okHttpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl("http://fenders.revotrends.mobi/index.php/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideUserAPI(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRepository(appApi: AppApi): ApiRepository {
        return ApiRepository(appApi)
    }

}