package com.app.dayregistry.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.dayregistry.ui.theme.DayRegistryTheme

@Composable
fun StartScreenMain(){

}

@Preview
@Composable
fun StartScreenPreviewNight(){
    DayRegistryTheme(true) {
        StartScreenMain()
    }
}

@Preview
@Composable
fun StartScreenPreviewDay(){
    DayRegistryTheme(false) {
        StartScreenMain()
    }
}