package com.fisi.sysvita.data.repository

import com.fisi.sysvita.network.LoginResponse

interface LoginRepository {
    suspend fun verificarLogin(email: String, contrasena: String): List<LoginResponse>
}
/*
class NetworkLoginRepository(): LoginRepository{
    override suspend fun verificarLogin(email: String, contrasena: String): List<SysVitaLogin> {
        return SysVitaApi.retrofitService.verificarLogin(email,contrasena)
    }
}*/