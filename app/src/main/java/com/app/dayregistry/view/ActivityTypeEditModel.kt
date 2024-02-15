package com.app.dayregistry.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.app.dayregistry.data.ActivityChipData
import com.app.dayregistry.database.ActivityTypesRepository


class ActivityTypeEditModel(
    savedStateHandle: SavedStateHandle,
    private val typesRepo: ActivityTypesRepository
) : ViewModel() {

    var editedActivity by mutableStateOf(ActivityChipData())


}