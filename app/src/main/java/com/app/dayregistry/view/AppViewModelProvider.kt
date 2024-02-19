package com.app.dayregistry.view

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.app.dayregistry.MainApplication

object AppViewModelProvider {
 val Factory = viewModelFactory {
     initializer {
         ActivityTypeEditModel(
             this.createSavedStateHandle(),
             mainApplication().container.repository
         )
     }
     initializer {
         ActivityListModel(
             mainApplication().container.repository
         )
     }
 }
}
fun CreationExtras.mainApplication(): MainApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as MainApplication)
