package com.logfitness.Entidades

class Ejercicio (val nombreIU : String, val categoria: String, val padre :String? ){
    val nombre_BD : String = nombreIU.lowercase().trim()
}