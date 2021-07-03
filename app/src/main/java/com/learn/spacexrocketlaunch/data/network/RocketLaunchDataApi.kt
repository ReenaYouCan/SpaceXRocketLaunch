package com.learn.spacexrocketlaunch.data.network

import com.learn.spacexrocketlaunch.domain.entities.RocketLaunchDataResponseItem
import io.reactivex.Observable
import retrofit2.http.GET

interface RocketLaunchDataApi {
    @GET("rockets")
    fun getRockets(): Observable<List<RocketLaunchDataResponseItem>>
}