package com.example.liveattendanceapp.views.attendance

import com.google.gson.annotations.SerializedName

data class ActivitiesOutRequest(

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
