package com.app.dayregistry.data

import androidx.compose.ui.graphics.vector.ImageVector
import com.app.dayregistry.screens.NavigationScreen

data class BottomNavigationElement(
    val title: String,
    val icon: ImageVector,
    val navigationScreen: NavigationScreen
)
