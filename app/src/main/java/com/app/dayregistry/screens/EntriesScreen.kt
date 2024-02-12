package com.app.dayregistry.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.app.dayregistry.components.BottomNavigationBar
import com.app.dayregistry.ui.theme.DayRegistryTheme

@Composable
fun EntriesScreenMain(
    navController: NavController
){
    Scaffold ( bottomBar = {
        BottomNavigationBar(navController)
    }
    ){ innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
        ){

        }
    }

}

/*@Preview
@Composable
fun EntriesScreenPreviewNight(){
    DayRegistryTheme(true) {
        EntriesScreenMain()
    }
}

@Preview
@Composable
fun EntriesScreenPreviewDay(){
    DayRegistryTheme(false) {
        EntriesScreenMain()
    }
}*/