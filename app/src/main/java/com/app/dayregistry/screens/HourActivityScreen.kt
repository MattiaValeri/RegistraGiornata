package com.app.dayregistry.screens

import android.content.res.Configuration
import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.dayregistry.R
import com.app.dayregistry.components.ActivityChip
import com.app.dayregistry.components.ActivityTab
import com.app.dayregistry.components.ButtonText
import com.app.dayregistry.components.MiniTextWithIcon
import com.app.dayregistry.components.TitleText
import com.app.dayregistry.ui.theme.DayRegistryTheme
import com.app.dayregistry.view.ActivitiesModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainHourActivityScreen(){
    Surface (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(21.dp)
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
                Spacer(modifier = Modifier.width(21.dp))
                MiniTextWithIcon(text = "01/01/20", icon = R.drawable.calendar_o)
            }
            Spacer(modifier = Modifier.height(15.dp))
            ActivityTab()
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                modifier = Modifier.align(Alignment.End),
                onClick = { /*TODO*/ },
            ){
                ButtonText(text = "Done")
            }
        }
    }
}

@Preview
@Composable
fun HourActivityPreviewNight(){
    DayRegistryTheme(true) {
        MainHourActivityScreen()
    }
}

@Preview
@Composable
fun HourActivityPreviewDay(){
    DayRegistryTheme(false) {
        MainHourActivityScreen()
    }
}

