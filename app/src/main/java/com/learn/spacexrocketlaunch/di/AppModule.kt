package com.learn.spacexrocketlaunch.di

import android.content.Context
import com.learn.spacexrocketlaunch.preferences.PreferenceHelper
import com.learn.spacexrocketlaunch.utils.Connectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun providePreferenceHelper(@ApplicationContext context: Context): PreferenceHelper =
        PreferenceHelper(context)

    @Provides
    @Singleton
    fun provideContextToConnectivity(@ApplicationContext context: Context): Connectivity =
        Connectivity(context)
}