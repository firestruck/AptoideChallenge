package com.dmanlancers.aptoide.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmanlancers.aptoide.domain.model.Aptoide
import com.dmanlancers.aptoide.domain.model.ListValues
import com.dmanlancers.aptoide.domain.usecase.GetAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AptoideViewModel @Inject constructor(private val getAppsUseCase: GetAppsUseCase) :
    ViewModel() {


    val appsReceivedLiveData = MutableLiveData<Aptoide>()
    val isLoad = MutableLiveData<Boolean>()
    val appData = MutableLiveData<Aptoide>()


    init {
        isLoad.value = false
    }


    fun set(apps: Aptoide) = run { appData.value = apps }

    fun loadApps() {


        getAppsUseCase.execute(
            onSuccess = {
                isLoad.value = true
                appsReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }


}

