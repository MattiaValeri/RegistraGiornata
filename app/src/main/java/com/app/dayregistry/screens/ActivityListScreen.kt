package com.app.dayregistry.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.dayregistry.R
import com.app.dayregistry.components.ActivityAddButton
import com.app.dayregistry.components.ActivityChip
import com.app.dayregistry.components.TitleText
import com.app.dayregistry.ui.theme.DayRegistryTheme

object ActivityListDestination: NavigationDestination{
    override val route: String = "activities"
    override val titleRes: Int = 0
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ActivityListScreen(
    onCreateActivity: () -> Unit,
    bottomNavigation: @Composable ()->Unit
) {
    Scaffold (
        bottomBar = {
            bottomNavigation()
        }
    ){ innerPadding ->
        Surface (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(dimensionResource(id = R.dimen.app_padding))
                .fillMaxSize(),
        ){
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .fillMaxSize(),
            )
            {
                Column {
                    TitleText(text = "Your Activities")
                    Spacer(modifier = Modifier.height(16.dp))

                    FlowRow (
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        ActivityAddButton (onClick = onCreateActivity)

                    }
                }
            }

        }

    }
}

@Preview
@Composable
fun ActivityListPreviewNight(){
    DayRegistryTheme(true) {
        ActivityListScreen (onCreateActivity = {}){ BottomNavigationBar() }
    }
}

@Preview
@Composable
fun ActivityListPreviewDay(){
    DayRegistryTheme(false) {
        ActivityListScreen (onCreateActivity = {}){ BottomNavigationBar() }
    }
}