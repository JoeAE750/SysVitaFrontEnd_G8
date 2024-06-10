package com.fisi.sysvita.ui.uistate

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isSuccesful: Boolean = false,
)
