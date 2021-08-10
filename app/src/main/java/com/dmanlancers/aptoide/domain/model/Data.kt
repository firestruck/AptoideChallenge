package com.dmanlancers.aptoide.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data (

	val total : Int,
	val offset : Int,
	val limit : Int,
	val next : Int,
	val hidden : Int,
	val list : List<ListValues>
)