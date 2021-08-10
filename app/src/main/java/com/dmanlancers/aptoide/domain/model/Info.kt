package com.dmanlancers.aptoide.domain.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info (

	val status : String,
	val time : Time
)