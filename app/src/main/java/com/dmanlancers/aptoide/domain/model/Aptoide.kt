package com.dmanlancers.aptoide.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Aptoide (

	val status : String,
	val responses : Responses
)