package com.learn.spacexrocketlaunch.di

import android.content.Context
import androidx.room.Room
import com.learn.spacexrocketlaunch.data.LAUNCH_DATA_DATABASE_NAME
import com.learn.spacexrocketlaunch.data.db.RocketLaunchDataDao
import com.learn.spacexrocketlaunch.data.db.RocketLaunchDataDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideLaunchDataDao(databaseRocket: RocketLaunchDataDatabase): RocketLaunchDataDao {
        return databaseRocket.launchDataDao()
    }

    @Provides
    @Singleton
    fun provideLaunchDataDatabase(@ApplicationContext applicationContext: Context): RocketLaunchDataDatabase {
        return Room.databaseBuilder(
            applicationContext,
            RocketLaunchDataDatabase::class.java,
            LAUNCH_DATA_DATABASE_NAME
        ).allowMainThreadQueries()
            .build()
    }

}