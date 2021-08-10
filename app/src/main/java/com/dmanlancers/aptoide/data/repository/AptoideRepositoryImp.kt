package com.dmanlancers.aptoide.data.repository

import com.dmanlancers.aptoide.data.source.remote.AptoideService
import com.dmanlancers.aptoide.domain.model.Aptoide
import com.dmanlancers.aptoide.domain.model.ListValues
import com.dmanlancers.aptoide.domain.repository.AptoideRepository
import io.reactivex.Single

/**
 * This repository is responsible for
 * fetching data[Aptoide] from server
 * */
class AptoideRepositoryImp(
    private val aptoideService: AptoideService
) :
    AptoideRepository {


    override fun getApps(): Single<Aptoide> {
        return aptoideService.getApps()
    }


}