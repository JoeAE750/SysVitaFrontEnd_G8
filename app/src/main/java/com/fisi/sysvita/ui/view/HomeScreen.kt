package com.fisi.sysvita.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fisi.sysvita.R
import com.fisi.sysvita.ui.components.SysVitaTopBar
import com.fisi.sysvita.ui.theme.SysVitaTheme



@Composable
fun HomeScreen(onLoginClick: () -> Unit) {
    //var esEspecialista = false
    Scaffold(topBar = {
        SysVitaTopBar(
            canNavigateBack = false,
            navigateUp = {},
            title = "Universidad Nacional Mayor de San Marcos"
        )
    }, bottomBar = {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(height = 55.dp, width = 395.dp)
        ) {

        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.padding(top = 36.dp, bottom = 36.dp),
                text = "SysVita",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            val imagePainter = painterResource(id = R.drawable.sysvita_launcher_foreground)
            Image(
                painter = imagePainter,
                contentDescription = "Icono Sysvita",
                modifier = Modifier.size(100.dp)
            )

            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .padding(top = 50.dp, bottom = 30.dp)
                    .size(width = 200.dp, height = 40.dp)
            ) {
                Text("Usuario", fontSize = 17.sp)
            }


            FilledTonalButton(
                onClick = onLoginClick,
                modifier = Modifier.size(width = 200.dp, height = 40.dp)
            ) {
                Text("Especialista", fontSize = 17.sp)
            }


        }
    }

}

@Preview
@Composable
fun PreviewLayout() {
    SysVitaTheme(darkTheme = false) {
        HomeScreen(onLoginClick = {})
    }
}