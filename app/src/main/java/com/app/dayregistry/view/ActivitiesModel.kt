package com.app.dayregistry.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.app.dayregistry.data.ActivityChipData
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow

class ActivitiesModel : ViewModel() {

    var listOfActivity = mutableStateListOf<ActivityChipData>()
        private set




    fun addActivity(activity: ActivityChipData){
        listOfActivity += activity
    }

    fun removeActivity(activity: ActivityChipData){
        listOfActivity -= activity
    }

}