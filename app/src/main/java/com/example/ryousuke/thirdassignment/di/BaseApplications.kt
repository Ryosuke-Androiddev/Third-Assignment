package com.example.ryousuke.thirdassignment.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplications: Application() {

    override fun onCreate() {
        super.onCreate()

        /* You have make Application class to use Timber at first.Second, you have to add permission to manifest.
        Third, you have set up code under the this line!!
        * */

        Timber.plant(Timber.DebugTree())
    }
}