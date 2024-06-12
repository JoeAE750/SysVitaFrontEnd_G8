package com.fisi.sysvita.data.model

data class Especialista(
    val idmedico: String,
    val idespecialidad: Int,
    val idfacultad: Int,
    val nombre: String,
    val apellido: String,
    val fechanac: String,
    val genero: Int,
    val dni: String,
    val email: String,
    val contrasena: String
)
