package com.app.dayregistry.database

import kotlinx.coroutines.flow.Flow

class ActivityTypesRepository(private val activityTypesDao: ActivityTypesDao)
{
    fun getAllItemsStream(): Flow<List<ActivityTypes>> = activityTypesDao.getAllActivityTypes()

    fun getItemStream(name: String): Flow<ActivityTypes?> = activityTypesDao.getActivityFromName(name)

    suspend fun insertItem(item: ActivityTypes) = activityTypesDao.insert(item)

    suspend fun deleteItem(item: ActivityTypes) = activityTypesDao.delete(item)

    suspend fun updateItem(item: ActivityTypes) = activityTypesDao.update(item)
}