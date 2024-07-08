package com.example.liveattendanceapp.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(

	@field:SerializedName("lastLocation")
	val lastLocation: LastLocation? = null
)

data class LastLocation(

	@field:SerializedName("maxdistance")
	val maxdistance: Double? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("latitude")
	val latitude: Double? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("longitude")
	val longitude: Double? = null
)
