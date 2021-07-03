package com.learn.spacexrocketlaunch.data.repository

import com.learn.spacexrocketlaunch.data.db.RocketLaunchDataDao
import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.domain.usecases.GetRocketLaunchDataUseCase
import com.learn.spacexrocketlaunch.utils.Connectivity
import io.reactivex.Observable
import javax.inject.Inject

class RocketLaunchDataRepository @Inject constructor(
    private val launchDataUseCase: GetRocketLaunchDataUseCase,
    private val rocketLaunchDataDao: RocketLaunchDataDao,
    private val connectivity: Connectivity
) {
    fun getRocketLaunchData(): Observable<List<RocketLaunchDataModel>> = when {
        connectivity.hasNetworkAccess() -> {
            launchDataUseCase.getRocketLaunchDataFromApi()
        }
        else -> {
            Observable.just(rocketLaunchDataDao.getLaunchDataFromDb())
        }
    }

    fun saveLaunchDataToLocalDb(launchDataList: List<RocketLaunchDataModel>) {
        rocketLaunchDataDao.clearDb()
        launchDataList.forEach { rocketLaunchDataDao.saveLaunchData(it) }
    }

}