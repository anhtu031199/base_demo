package com.tuna.ctech.di

import com.tuna.ctech.data.repository.impl.EmployeeRepositoryImpl
import com.tuna.ctech.data.repository.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
//    @Binds
//    abstract fun bindWeatherRepository(
//        myRepositoryImpl: WeatherRepositoryImpl
//    ): WeatherRepository

    @Binds
    abstract fun bindEmployeeRepository(
        myRepositoryImpl: EmployeeRepositoryImpl
    ): EmployeeRepository
}
