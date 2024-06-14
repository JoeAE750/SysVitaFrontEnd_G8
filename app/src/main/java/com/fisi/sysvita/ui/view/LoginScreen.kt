package com.fisi.sysvita.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fisi.sysvita.R
import com.fisi.sysvita.ui.components.ConexionUIState
import com.fisi.sysvita.ui.components.ErrorScreen
import com.fisi.sysvita.ui.components.LoadingScreen
import com.fisi.sysvita.ui.components.SysVitaBottomBar
import com.fisi.sysvita.ui.components.SysVitaTopBar
import com.fisi.sysvita.ui.theme.SysVitaTheme
import com.fisi.sysvita.ui.viewmodel.LoginViewModel


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    loginUIConexion: ConexionUIState = ConexionUIState.Success
) {

    Scaffold(topBar = {
        SysVitaTopBar(canNavigateBack = false, title = "Login")
    }, bottomBar = {
        SysVitaBottomBar()
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (loginUIConexion) {
                is ConexionUIState.Success -> {

                }

                is ConexionUIState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
                is ConexionUIState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
            }
            val imagePainter = painterResource(id = R.drawable.sysvita_launcher_foreground)
            Image(
                painter = imagePainter,
                contentDescription = "Icono Sysvita",
                modifier = Modifier.size(100.dp)
            )

            Row {
                Text(text = "Email", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = loginViewModel.email,
                    onValueChange = { loginViewModel.email = it },
                    trailingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    keyboardActions = KeyboardActions(onDone = { }),
                    singleLine = true
                )
            }



            Row {
                Text(text = "Contraseña", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                TextField(
                    value = loginViewModel.contrasena,
                    onValueChange = { loginViewModel.contrasena = it },
                    trailingIcon = { Icon(Icons.Default.Lock, contentDescription = "Contraseña") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    keyboardActions = KeyboardActions(onDone = { }),
                    singleLine = true
                )
            }

            Button(onClick = {
                loginViewModel.validarLogin()
            }
            )
            { Text(text = "Iniciar Sesion", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
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

