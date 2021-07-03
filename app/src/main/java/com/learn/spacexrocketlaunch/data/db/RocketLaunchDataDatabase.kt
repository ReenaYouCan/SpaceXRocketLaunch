package com.learn.spacexrocketlaunch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel

@Database(entities = [RocketLaunchDataModel::class], version = 1, exportSchema = false)
@TypeConverters(DataTypeConverters::class)
abstract class RocketLaunchDataDatabase : RoomDatabase() {
    abstract fun launchDataDao(): RocketLaunchDataDao
}