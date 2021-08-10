package com.dmanlancers.aptoide

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
This Class represent the Application singleton and it's responsible to start Timber and if needed in the future, other components

 **/

@HiltAndroidApp
open class AptoideApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        setupTimber()

    }

    private fun setupTimber() {

        Timber.plant(Timber.DebugTree())
    }
}