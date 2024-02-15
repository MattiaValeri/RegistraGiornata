package com.app.dayregistry.database

import androidx.compose.ui.graphics.Color
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityTypesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: ActivityTypes)

    @Update
    suspend fun update(item: ActivityTypes)

    @Delete
    suspend fun delete(item: ActivityTypes)

    @Upsert
    suspend fun updateOrInsertItem(item: ActivityTypes)

    @Query("SELECT * from activity_types WHERE name = :name")
    fun getActivityFromName(name: String): Flow<ActivityTypes>

    @Query("SELECT * from activity_types ORDER BY name ASC")
    fun getAllActivityTypes(): Flow<List<ActivityTypes>>
}