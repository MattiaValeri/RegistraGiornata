package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.dayregistry.R
import com.app.dayregistry.ui.theme.DayRegistryTheme

object ActivityTypesModifyDestination: NavigationDestination{
    override val route: String = "types_modify"
    override val titleRes: Int = 0
}

@Composable
fun ActivityTypesModifyScreen(){
    Surface (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(dimensionResource(id = R.dimen.app_padding))
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ){

        }
    }
}

@Preview
@Composable
private fun ActivityTypesModifyPreviewNight(){
    DayRegistryTheme(true) {
        ActivityTypesModifyScreen()
    }
}

@Preview
@Composable
private fun ActivityTypesModifyPreviewDay(){
    DayRegistryTheme(false) {
        ActivityTypesModifyScreen()
    }
}