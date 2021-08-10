package com.dmanlancers.aptoide.domain.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListValues (

	val id : Int,
	val name : String,
	val store_id : Int,
	val store_name : String,
	val vername : String,
	val vercode : Int,
	val md5sum : String,
	val apk_tags : List<String>,
	val size : String,
	val downloads : Int,
	val pdownloads : Int,
	val added : String,
	val modified : String,
	val updated : String,
	val rating : String,
	val icon : String,
	val graphic : String?,
	val uptype : String
)