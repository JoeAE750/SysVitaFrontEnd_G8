package com.fisi.sysvita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fisi.sysvita.ui.theme.SysVitaTheme
import com.fisi.sysvita.network.SysVitaApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SysVitaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    val name = getUserEmail()
                    Greeting(
                        name = name,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SysVitaTheme {
        Greeting("Android")
    }
}

private fun getUserEmail(): String {
    val listResult = SysVitaApi.retrofitService.getEmail("Joel.aguilar1@unmsm.edu.pe")
    return listResult
}