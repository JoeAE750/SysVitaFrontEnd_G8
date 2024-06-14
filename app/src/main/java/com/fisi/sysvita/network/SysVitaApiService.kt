package com.fisi.sysvita.network

import retrofit2.http.GET
import retrofit2.http.Path

interface SysVitaApiService {

    @GET("usuarios")
    suspend fun getUsuarios(): String

    @GET("usuarios/email/{email}")
    fun getEmail(@Path("email") email: String): String
}
