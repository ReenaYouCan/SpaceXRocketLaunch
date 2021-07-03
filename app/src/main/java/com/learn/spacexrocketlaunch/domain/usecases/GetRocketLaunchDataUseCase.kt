package com.learn.spacexrocketlaunch.domain.usecases

import com.learn.spacexrocketlaunch.data.mapper.RocketLaunchDataMapper
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.data.network.RocketLaunchDataApi
import io.reactivex.Observable
import javax.inject.Inject

class GetRocketLaunchDataUseCase @Inject constructor(private val rocketLaunchDataApi: RocketLaunchDataApi) {

    fun getRocketLaunchDataFromApi(): Observable<List<RocketLaunchDataModel>> {
        return rocketLaunchDataApi.getRockets().flatMap {
            Observable.fromIterable(it).filter { item -> item.active }.toList().toObservable()
        }.map { RocketLaunchDataMapper.map(it) }
    }
}