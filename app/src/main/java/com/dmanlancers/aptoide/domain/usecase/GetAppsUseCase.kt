package com.dmanlancers.aptoide.domain.usecase

import com.dmanlancers.aptoide.domain.model.Aptoide
import com.dmanlancers.aptoide.domain.model.ListValues
import com.dmanlancers.aptoide.domain.repository.AptoideRepository
import com.dmanlancers.aptoide.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject


/**
 * An interactor that calls the actual implementation of [AptoideViewModel](which is injected by DI)
 * it handles the response that returns data &
 * contains a list of actions, event steps
 */
class GetAppsUseCase @Inject constructor(private val repository: AptoideRepository) : SingleUseCase<Aptoide>() {


    override fun buildUseCaseSingle(): Single<Aptoide> {
        return repository.getApps()
    }




}
