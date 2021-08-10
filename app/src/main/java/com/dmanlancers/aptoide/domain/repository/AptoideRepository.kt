package com.dmanlancers.aptoide.domain.repository

import com.dmanlancers.aptoide.domain.model.Aptoide
import com.dmanlancers.aptoide.domain.model.ListValues
import io.reactivex.Single


/**
 * To make an interaction with AptoideRepositoryImp
 * */
interface AptoideRepository {

    fun getApps(): Single<Aptoide>


}