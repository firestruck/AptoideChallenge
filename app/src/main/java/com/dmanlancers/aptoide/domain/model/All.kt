package com.dmanlancers.aptoide.domain.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class All (

	val info : Info,
	val data : Data
)