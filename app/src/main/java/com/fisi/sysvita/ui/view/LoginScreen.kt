package com.fisi.sysvita.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fisi.sysvita.R
import com.fisi.sysvita.ui.theme.SysVitaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var textEmail by remember { mutableStateOf("") }
    var textPassword by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ), navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Retroceder",
                        modifier = Modifier.offset(x = 10.dp, y = 1.dp)
                    )
                },
                title = {
                    Text(
                        "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.offset(x = 20.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {}
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imagePainter = painterResource(id = R.drawable.sysvita_launcher_foreground)
            Image(
                painter = imagePainter,
                contentDescription = "Icono Sysvita",
                modifier = Modifier.size(100.dp)
            )

            Row() {
                Text(text = "Email", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = textEmail,
                    onValueChange = { textEmail = it },
                    trailingIcon = { Icon(Icons.Default.Email, contentDescription = "Retroceder") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }


            Row() {
                Text(text = "Contraseña", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = textPassword,
                    onValueChange = { textPassword = it },
                    trailingIcon = { Icon(Icons.Default.Lock, contentDescription = "Retroceder") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }

            Button(onClick = {

            }) {
                Text(text = "Iniciar Sesion", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }

        }


    }


}


@Preview
@Composable
fun LoginScreenPreview() {
    SysVitaTheme(darkTheme = false) {
        LoginScreen()
    }
}

