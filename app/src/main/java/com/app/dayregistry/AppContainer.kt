package com.app.dayregistry

import android.content.Context
import com.app.dayregistry.database.ActivityTypesDao
import com.app.dayregistry.database.ActivityTypesRepository
import com.app.dayregistry.database.AppDatabase

interface AppContainer {
    val repository: ActivityTypesRepository
}

class AppActivityTypeContainer(private val context: Context) : AppContainer {
    override val repository: ActivityTypesRepository by lazy {
        ActivityTypesRepository(AppDatabase.getDatabase(context).activityTypeDao())
    }
}
