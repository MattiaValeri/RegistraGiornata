package com.app.dayregistry.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class NavigationScreen() {
    ENTRIES,
    STATS,
    ADD,
    CALENDAR,
    SETTINGS
}

@Composable
fun Navigation(
    navController: NavHostController =  rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = NavigationScreen.valueOf(
        backStackEntry?.destination?.route ?: NavigationScreen.ENTRIES.name
    )

    NavHost(
        navController = navController,
        startDestination = NavigationScreen.ENTRIES.name,
    ) {
        composable(route = NavigationScreen.ENTRIES.name) {
            EntriesScreenMain(navController = navController)
        }
        composable(route = NavigationScreen.ADD.name) {
            MainHourActivityScreen()
        }
    }
}