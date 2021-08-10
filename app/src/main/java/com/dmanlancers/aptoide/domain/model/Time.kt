package com.dmanlancers.aptoide.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Time (

	val seconds : Double,
	val human : String
)