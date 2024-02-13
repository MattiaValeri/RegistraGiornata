package com.app.dayregistry.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "activity_types",
    foreignKeys = [ForeignKey(
    entity = ActivityTypes::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("activity"),
    onDelete = ForeignKey.CASCADE
    )],
    primaryKeys = ["activity", "hour", "minute", "month", "day"]
    )
data class Activities(
    val activity: Int,
    val hour: Int,
    val minute: Int,
    val month: Int,
    val day: Int,
)
