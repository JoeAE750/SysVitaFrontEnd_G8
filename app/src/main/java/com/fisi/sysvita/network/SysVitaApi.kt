package com.fisi.sysvita.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


private const val BASE_URL =
    "https://sysvitabackend-g8.onrender.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object SysVitaApi {
    val retrofitService: SysVitaApiService by lazy {
        retrofit.create(SysVitaApiService::class.java)
    }
}