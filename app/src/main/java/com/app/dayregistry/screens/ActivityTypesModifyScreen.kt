package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.dayregistry.R
import com.app.dayregistry.components.NormalOutlinedTextField
import com.app.dayregistry.components.NormalText
import com.app.dayregistry.components.TitleText
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
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TitleText(
                modifier = Modifier.fillMaxWidth(),
                text = "Create a new Activity",
                textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            NormalOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = "Activity Name"
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.align(Alignment.End),
                onClick = { /*TODO*/ },
            ){
                NormalText(text = "Done")
            }
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