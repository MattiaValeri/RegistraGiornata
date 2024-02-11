package com.app.dayregistry

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.dayregistry.screens.MainHourActivityScreen
import com.app.dayregistry.ui.theme.DayRegistryTheme

private const val TAG = "MAIN_ACTIVITY_DEBUG"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DayRegistryTheme {
                MainHourActivityScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    // No longer focus.
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    // No longer on the foreground.
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}
