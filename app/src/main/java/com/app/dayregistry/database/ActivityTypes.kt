package com.app.dayregistry.database

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.dayregistry.data.ActivityChipData

@Entity(tableName = "activity_types")
data class ActivityTypes(
    @PrimaryKey
    val name: String,
    //@ColumnInfo(defaultValue = "MaterialTheme.colorScheme.surface")
    val color: Color
)


fun ActivityTypes.toActivityChipData(): ActivityChipData = ActivityChipData(
    activity = name,
    color = color
)

