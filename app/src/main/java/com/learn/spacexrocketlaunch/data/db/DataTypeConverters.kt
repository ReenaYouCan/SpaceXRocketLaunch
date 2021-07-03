package com.learn.spacexrocketlaunch.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import java.lang.reflect.Type

@ProvidedTypeConverter
class DataTypeConverters {
    @TypeConverter
    fun stringToList(json: String?): List<RocketLaunchDataModel>? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<RocketLaunchDataModel?>?>() {}.type
        return gson.fromJson<List<RocketLaunchDataModel>>(json, type)
    }

    @TypeConverter
    fun listToString(list: List<RocketLaunchDataModel?>?): String? {
        val gson = Gson()
        val type: Type = object : TypeToken<List<RocketLaunchDataModel?>?>() {}.type
        return gson.toJson(list, type)
    }
}