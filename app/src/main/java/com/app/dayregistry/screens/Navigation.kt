package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.dayregistry.data.BottomNavigationElement

enum class NavigationScreen() {
    ENTRIES,
    ACTIVITIES,
    ADD,
    CALENDAR,
    SETTINGS
}

interface NavigationDestination{
    val route: String
    // Int because there should be a String Resource.
    val titleRes: Int
}

@Composable
fun Navigation(
    navController: NavHostController =  rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()

    /*val currentScreen = NavigationScreen.valueOf(
        backStackEntry?.destination?.route ?: NavigationScreen.ENTRIES.name
    )*/

    NavHost(
        navController = navController,
        startDestination = EntriesDestination.route,
    ) {
        composable(route = EntriesDestination.route) {
            EntriesScreenMain {
                BottomNavigationBar(navController)
            }
        }
        composable(route = ActivityListDestination.route){
            ActivityListScreenList (
                onCreateActivity = {
                    navController.navigate(ActivityTypesModifyDestination.route) },
                bottomNavigation = {
                    BottomNavigationBar(navController) },
                activityList = listOf()
            )
        }
        composable(route = HourlyAddDestination.route) {
            HourlyAddActivityScreen()
        }
        composable(route = ActivityTypesModifyDestination.route) {
            ActivityTypesModifyScreen()
        }
    }
}

val bottomNavButtons = listOf(
    BottomNavigationElement(
        title = "Entries",
        icon = Icons.Rounded.List,
        navigationScreen = EntriesDestination.route
    ),
    BottomNavigationElement(
        title = "Activities",
        icon = Icons.Rounded.Edit,
        navigationScreen = ActivityListDestination.route
    ),
    BottomNavigationElement(
        title = "Add",
        icon = Icons.Rounded.Add,
        navigationScreen = HourlyAddDestination.route
    ),
    BottomNavigationElement(
        title = "Calendar",
        icon = Icons.Rounded.DateRange,
        navigationScreen = ""
    ),
    BottomNavigationElement(
        title = "Settings",
        icon = Icons.Rounded.Settings,
        navigationScreen = ""
    ),
)

@Composable
fun BottomNavigationBar(
    navController: NavHostController? = null
){
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            bottomNavButtons.forEachIndexed{ index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { navController?.navigate(item.navigationScreen) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = item.title
                        )
                    }
                )
            }
        }
    }
}