package com.learn.spacexrocketlaunch.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learn.spacexrocketlaunch.data.LAUNCH_DATA_TABLE_NAME
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel

@Dao
interface RocketLaunchDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLaunchData(launchDataModel: RocketLaunchDataModel)

    @Query("SELECT * FROM $LAUNCH_DATA_TABLE_NAME")
    fun getLaunchDataFromDb(): List<RocketLaunchDataModel>

    @Query("DELETE FROM $LAUNCH_DATA_TABLE_NAME")
    fun clearDb()
}