package com.tuna.ctech.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tuna.ctech.BuildConfig
import com.tuna.ctech.data.remote.services.EmployeeService
import com.tuna.nothingapp.data.remote.services.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideGsonConverter(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
//
//    @Singleton
//    @Provides
//    fun provideWeatherService(
//        okHttpClient: OkHttpClient,
//        gsonConverterFactory: GsonConverterFactory
//    ): WeatherService = Retrofit.Builder()
//        .addConverterFactory(gsonConverterFactory)
//        .client(okHttpClient)
//        .baseUrl(BuildConfig.BASE_URL)
//        .build()
//        .create(WeatherService::class.java)

    @Singleton
    @Provides
    fun provideEmployeeService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): EmployeeService = Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .build()
        .create(EmployeeService::class.java)


}