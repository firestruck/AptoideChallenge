package com.dmanlancers.aptoide.data.source.remote

import com.dmanlancers.aptoide.domain.model.Aptoide
import com.dmanlancers.aptoide.domain.model.ListValues
import io.reactivex.Single
import retrofit2.http.GET

/**
 * This  is the retrofit interface
 * */
interface AptoideService {

    @GET("6/bulkRequest/api_list/listApps")
    fun getApps(): Single<Aptoide>


}