package com.app.dayregistry.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.app.dayregistry.data.BottomNavigationElement
import com.app.dayregistry.screens.NavigationScreen

val items = listOf(
    BottomNavigationElement(
        title = "Entries",
        icon = Icons.Rounded.List,
        navigationScreen = NavigationScreen.ENTRIES
    ),
    BottomNavigationElement(
        title = "Stats",
        icon = Icons.Rounded.Info,
        navigationScreen = NavigationScreen.STATS
    ),
    BottomNavigationElement(
        title = "Add",
        icon = Icons.Rounded.Add,
        navigationScreen = NavigationScreen.ADD
    ),
    BottomNavigationElement(
        title = "Calendar",
        icon = Icons.Rounded.DateRange,
        navigationScreen = NavigationScreen.CALENDAR
    ),
    BottomNavigationElement(
        title = "Settings",
        icon = Icons.Rounded.Settings,
        navigationScreen = NavigationScreen.SETTINGS
    ),
)

@Composable
fun BottomNavigationBar(
    navController: NavController
){
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEachIndexed{ index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { navController.navigate(item.navigationScreen.name) },
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