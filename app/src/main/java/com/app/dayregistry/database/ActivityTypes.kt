package com.app.dayregistry.database

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity_types")
data class ActivityTypes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    //@ColumnInfo(defaultValue = "MaterialTheme.colorScheme.surface")
    val color: Color
)
