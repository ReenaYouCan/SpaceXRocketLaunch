package com.learn.spacexrocketlaunch.domain.entities

import com.google.gson.annotations.SerializedName

data class RocketLaunchDataResponseItem(
    @SerializedName("height") var height: Height,
    @SerializedName("mass") var mass: Mass,
    @SerializedName("first_stage") var firstStage: FirstStage,
    @SerializedName("engines") var engines: Engines,
    @SerializedName("landing_legs") var landingLegs: LandingLegs,
    @SerializedName("payload_weights") var payloadWeights: List<PayloadWeights>,
    @SerializedName("flickr_images") var flickrImages: List<String>,
    @SerializedName("name") var name: String,
    @SerializedName("type") var type: String,
    @SerializedName("active") var active: Boolean,
    @SerializedName("stages") var stages: Int,
    @SerializedName("boosters") var boosters: Int,
    @SerializedName("cost_per_launch") var costPerLaunch: Int,
    @SerializedName("success_rate_pct") var successRatePct: Int,
    @SerializedName("first_flight") var firstFlight: String,
    @SerializedName("country") var country: String,
    @SerializedName("company") var company: String,
    @SerializedName("wikipedia") var wikipedia: String,
    @SerializedName("description") var description: String,
    @SerializedName("id") var id: String

)

data class Diameter(
    @SerializedName("meters") var meters: Double,
    @SerializedName("feet") var feet: Double
)

data class Engines(
    @SerializedName("number") var number: Int,
    @SerializedName("type") var type: String,
    @SerializedName("version") var version: String,
    @SerializedName("layout") var layout: String,
    @SerializedName("engine_loss_max") var engineLossMax: Int,
    @SerializedName("propellant_1") var propellant1: String,
    @SerializedName("propellant_2") var propellant2: String,
    @SerializedName("thrust_to_weight") var thrustToWeight: Double
)

data class FirstStage(

    @SerializedName("reusable") var reusable: Boolean,
    @SerializedName("engines") var engines: Int,
    @SerializedName("fuel_amount_tons") var fuelAmountTons: Double,
    @SerializedName("burn_time_sec") var burnTimeSec: Int
)

data class Height(
    @SerializedName("meters") var meters: Double,
    @SerializedName("feet") var feet: Double
)

data class LandingLegs(
    @SerializedName("material") val material: String,
    @SerializedName("number") val number: Int
)

data class Mass(
    @SerializedName("kg") val kg: Int,
    @SerializedName("lb") val lb: Int
)

data class PayloadWeights(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("kg") var kg: Int,
    @SerializedName("lb") var lb: Int

)

