package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.dayregistry.R
import com.app.dayregistry.components.ActivityTab
import com.app.dayregistry.components.NormalText
import com.app.dayregistry.components.MiniTextWithIcon
import com.app.dayregistry.components.TitleText
import com.app.dayregistry.data.ActivityChipData
import com.app.dayregistry.ui.theme.DayRegistryTheme
import com.app.dayregistry.view.EditingActivitiesModel

object HourlyAddDestination: NavigationDestination{
    override val route: String = "hourly_add"
    override val titleRes: Int = 0

}

@Composable
fun HourlyAddActivityScreen(
    model : EditingActivitiesModel = viewModel()
){
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
            TitleText(text = "How Are You?")
            Row {
                MiniTextWithIcon(text = "12:34", icon = R.drawable.clock)
                Spacer(modifier = Modifier.width(20.dp))
                MiniTextWithIcon(text = "01/01/20", icon = R.drawable.calendar_o)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ActivityTab(
                activities = model.listOfActivity,
                onActivityChipClick = {
                    chip: ActivityChipData->
                    model.removeActivity(ActivityChipData(chip.activity)
                )},
                onAddActivity = {},
                enableAdding = true,
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
private fun HourActivityPreviewNight(){
    DayRegistryTheme(true) {
        HourlyAddActivityScreen()
    }
}

@Preview
@Composable
private fun HourActivityPreviewDay(){
    DayRegistryTheme(false) {
        HourlyAddActivityScreen()
    }
}

