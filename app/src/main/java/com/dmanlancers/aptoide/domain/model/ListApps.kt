package com.dmanlancers.aptoide.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListApps (

	val info : Info,
	val datasets : Datasets
)