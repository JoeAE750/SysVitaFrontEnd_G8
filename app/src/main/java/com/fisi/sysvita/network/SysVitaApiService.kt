package com.fisi.sysvita.network

import retrofit2.http.GET
import retrofit2.http.Path

public interface SysVitaApiService {
    @GET("usuarios/email/{email}")
    fun getEmail(@Path("email") email: String): String
}


