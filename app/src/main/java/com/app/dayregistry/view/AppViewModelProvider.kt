package com.app.dayregistry.view

import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.app.dayregistry.MainApplication

object AppViewModelProvider {
 val Factory = viewModelFactory {
     initializer {
         ActivityTypeEditModel(
             this.createSavedStateHandle(),
             MainApplication().container.repository
         )
     }
 }
}