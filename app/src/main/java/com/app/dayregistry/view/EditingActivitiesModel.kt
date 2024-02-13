package com.app.dayregistry.view

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.app.dayregistry.data.ActivityChipData

class EditingActivitiesModel : ViewModel() {

    var listOfActivity = mutableStateListOf<ActivityChipData>()
        private set

    fun addActivity(activity: ActivityChipData){
        listOfActivity += activity
    }

    fun removeActivity(activity: ActivityChipData){
        listOfActivity -= activity
    }

}