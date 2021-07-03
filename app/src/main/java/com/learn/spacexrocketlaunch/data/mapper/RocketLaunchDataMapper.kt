package com.learn.spacexrocketlaunch.data.mapper

import com.learn.spacexrocketlaunch.data.model.RocketLaunchDataModel
import com.learn.spacexrocketlaunch.domain.entities.RocketLaunchDataResponseItem

object RocketLaunchDataMapper :
    Mapper<List<RocketLaunchDataResponseItem>, List<RocketLaunchDataModel>> {
    override fun map(from: List<RocketLaunchDataResponseItem>): List<RocketLaunchDataModel> {
        return from.map {
            RocketLaunchDataModel(
                name = it.name,
                country = it.country,
                enginesCount = it.engines.number,
                flickerImage = it.flickrImages[0]
            )
        }
    }
}