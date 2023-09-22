package com.tuna.ctech.di

import com.tuna.ctech.navigation.Navigator
import com.tuna.ctech.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class FragmentModule {
    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}