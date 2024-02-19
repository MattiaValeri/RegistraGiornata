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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.dayregistry.R
import com.app.dayregistry.components.ActivityAddButton
import com.app.dayregistry.components.ActivityChip
import com.app.dayregistry.components.TitleText
import com.app.dayregistry.database.ActivityTypes
import com.app.dayregistry.ui.theme.DayRegistryTheme
import com.app.dayregistry.view.ActivityListModel
import com.app.dayregistry.view.AppViewModelProvider

object ActivityListDestination: NavigationDestination{
    override val route: String = "activities"
    override val titleRes: Int = 0
}

@Composable
fun ActivityListScreen(
    onCreateActivity: () -> Unit,
    bottomNavigation: @Composable ()->Unit,
    viewModel: ActivityListModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val activityListState by viewModel.activityListState.collectAsState()
    ActivityListScreenList(
        onCreateActivity = { onCreateActivity() },
        bottomNavigation = { bottomNavigation() },
        activityList = activityListState.itemList
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ActivityListScreenList(
    onCreateActivity: () -> Unit,
    bottomNavigation: @Composable ()->Unit,
    viewModel: ActivityListModel = viewModel(factory = AppViewModelProvider.Factory),
    activityList: List<ActivityTypes>
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
                        ActivityAddButton (
                            modifier = Modifier.padding(end = 12.dp, bottom = 8.dp),
                            onClick = onCreateActivity
                        )
                        activityList.forEach{
                            ActivityChip(
                                activity = it.name,
                                color = it.color,
                                onClick = { /*onActivityChipClick(it)*/ }
                            )
                        }
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
        ActivityListScreenList (onCreateActivity = {},
            bottomNavigation = {BottomNavigationBar()},
            activityList = listOf(
                ActivityTypes(name = "Penis", color = Color.Cyan),
                ActivityTypes(name = "Penis2", color = Color.White)

            )
        )
    }
}

@Preview
@Composable
fun ActivityListPreviewDay(){
    DayRegistryTheme(false) {
        ActivityListScreenList (onCreateActivity = {},
            bottomNavigation = {BottomNavigationBar()},
            activityList = listOf()
        )
    }
}