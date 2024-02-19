package com.app.dayregistry.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.dayregistry.data.ActivityChipData
import com.app.dayregistry.database.ActivityTypes
import com.app.dayregistry.database.ActivityTypesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ActivityListModel(
    typesRepo: ActivityTypesRepository
) : ViewModel() {

    val activityListState: StateFlow<ActivityListState> =
        typesRepo.getAllItemsStream().map { ActivityListState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ActivityListState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * Ui State for HomeScreen
 */
data class ActivityListState(val itemList: List<ActivityTypes> = listOf())