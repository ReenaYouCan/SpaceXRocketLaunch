package com.learn.spacexrocketlaunch.di

import android.content.Context
import com.learn.spacexrocketlaunch.data.BASE_URL
import com.learn.spacexrocketlaunch.data.network.RocketLaunchDataApi
import com.learn.spacexrocketlaunch.utils.Connectivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRocketService(): RocketLaunchDataApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RocketLaunchDataApi::class.java)
    }


}