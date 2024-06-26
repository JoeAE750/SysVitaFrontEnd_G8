package com.fisi.sysvita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fisi.sysvita.navigation.SysVitaApp
import com.fisi.sysvita.ui.theme.SysVitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SysVitaTheme {
                SysVitaApp()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SysVitaTheme {
        SysVitaApp()
    }
}

