package com.app.dayregistry.database

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "activities",
    foreignKeys = [ForeignKey(
    entity = ActivityTypes::class,
    parentColumns = arrayOf("name"),
    childColumns = arrayOf("activity"),
    onDelete = ForeignKey.CASCADE
    )],
    primaryKeys = ["activity", "hour", "minute", "month", "day"]
    )
data class Activities(
    val activity: String,
    val hour: Int,
    val minute: Int,
    val month: Int,
    val day: Int,
)
