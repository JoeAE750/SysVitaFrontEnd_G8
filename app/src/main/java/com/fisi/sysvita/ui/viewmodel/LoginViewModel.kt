package com.fisi.sysvita.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fisi.sysvita.ui.components.ConexionUIState
import com.fisi.sysvita.ui.uistate.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.IOException

class LoginViewModel : ViewModel() {
    // Login UI state
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    var email: String by mutableStateOf("")
    var contrasena: String by mutableStateOf("")

    var loginUIConexion: ConexionUIState by mutableStateOf(ConexionUIState.Loading)
        private set

    fun validarLogin() {
        try {
            if ("Joel.aguilar1@unmsm.edu.pe" == this.email && "Abretesesamo750" == this.contrasena) {
                _uiState.update { currentState ->
                    currentState.copy(isLoginSuccesfull = true)
                }
            }
        } catch (e: IOException) {
            ConexionUIState.Error
        }
    }
}

