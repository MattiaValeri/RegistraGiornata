package com.app.dayregistry.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.dayregistry.data.ActivityChipData
import com.app.dayregistry.ui.theme.Roboto
import com.app.dayregistry.view.ActivitiesModel

private const val TAG = "ACTIVITY_CODE_DEBUG"

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ActivityTab(
    model : ActivitiesModel = viewModel()
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .height(184.dp)
            .padding(start = 12.dp, end = 12.dp, top = 12.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ){
        FlowRow (
            modifier = Modifier
                .fillMaxSize()
        ){
            model.listOfActivity.forEach{
                ActivityChip(
                    activity = it.activity,
                    onClick = {  model.removeActivity(ActivityChipData(it.activity)) }
                )
            }
            ActivityAddButton(
                onClick = {
                    model.addActivity(ActivityChipData( getRandomString((1..10).random())))
                }
            )
        }
    }

}

@Composable
fun ActivityChip(
    modifier: Modifier = Modifier,
    activity: String,
    onClick: () -> Unit
){
    Surface(
        modifier = modifier
            .padding(end = 12.dp, bottom = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(modifier = Modifier) {
            Text(
                text = activity,
                modifier = Modifier
                    .padding(horizontal = 35.dp, vertical = 4.dp),
                style = TextStyle(
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
            )
        }
    }
}


@Composable
fun ActivityAddButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Surface(
        modifier = modifier
            .size(30.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(15.dp),
    ) {
        ButtonText(text = "+")
    }
}

private fun getRandomString(length: Int) : String {
    val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}


@Preview
@Composable
fun ExampleChip(){
    ActivityChip(activity = "Penis", onClick = {})
}