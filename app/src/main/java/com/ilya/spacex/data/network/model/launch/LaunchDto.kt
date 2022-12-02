package com.ilya.spacex.data.network.model.launch

import com.google.gson.annotations.SerializedName

data class LaunchDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("rocket")
    val rocketId: String,

    @SerializedName("date_utc")
    val date: String,

    @SerializedName("success")
    val status: Boolean
)