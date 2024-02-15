package com.app.dayregistry

import android.app.Application

class MainApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppActivityTypeContainer(this)
    }
}