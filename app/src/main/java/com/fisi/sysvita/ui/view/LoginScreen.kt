package com.fisi.sysvita.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.fisi.sysvita.ui.theme.SysVitaTheme
import com.fisi.sysvita.ui.viewmodel.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginAppBar(canNavigateBack: Boolean = false, navigateUp: () -> Unit = {}) {
    TopAppBar(colors = topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary,
    ), navigationIcon = {
        if (canNavigateBack) {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Retroceder"
                )
            }
        }
    }, title = {
        Text(
            "Login",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = 20.dp)
        )
    })
}

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val loginUiState by loginViewModel.uiState.collectAsState()

    Scaffold(topBar = {
        loginAppBar()
    }, bottomBar = {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary,
        ) {}
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    keyboardActions = KeyboardActions(onDone = { })
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
                    keyboardActions = KeyboardActions(onDone = { })
                )
            }

            Button(onClick = {
                loginViewModel.validarLogin()
            }) {
                Text(text = "Iniciar Sesion", fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }




            Text(
                text = loginUiState.isSuccesful.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

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

