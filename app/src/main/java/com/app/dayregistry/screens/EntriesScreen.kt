package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.dayregistry.R
import com.app.dayregistry.components.BottomNavigationBar
import com.app.dayregistry.components.NormalAppButton
import com.app.dayregistry.components.NormalText
import com.app.dayregistry.components.StaticActivityTab
import com.app.dayregistry.ui.theme.DayRegistryTheme

@Composable
fun EntriesScreenMain(
    navController: NavController
){
    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){ innerPadding ->
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(dimensionResource(id = R.dimen.app_padding))
                .fillMaxSize(),
        ){
            Surface(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                Column {
                    MonthBar("Month")
                    Spacer(modifier = Modifier.height(20.dp))
                    StaticActivityTab()
                }
            }
        }
    }
}

@Composable
fun MonthBar(
    monthText: String
){
    Box{
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            NormalAppButton(
                text = "<",
                onClick = { /*TODO*/ },
            )
            NormalText(text = monthText)
            NormalAppButton(
                text = ">",
                onClick = { /*TODO*/ },)
        }
    }

}


@Preview
@Composable
fun EntriesScreenPreviewNight(){
    DayRegistryTheme(true) {
        EntriesScreenMain(rememberNavController())
    }
}

@Preview
@Composable
fun EntriesScreenPreviewDay(){
    DayRegistryTheme(false) {
        EntriesScreenMain(rememberNavController())
    }
}