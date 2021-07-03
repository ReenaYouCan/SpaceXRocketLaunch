package com.learn.spacexrocketlaunch.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.learn.spacexrocketlaunch.data.LAUNCH_DATA_TABLE_NAME

@Entity(tableName = LAUNCH_DATA_TABLE_NAME)
data class RocketLaunchDataModel(
    @PrimaryKey
    val name: String,
    val country: String,
    val enginesCount: Int,
    val flickerImage: String
)
