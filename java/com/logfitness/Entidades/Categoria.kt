package com.logfitness.Entidades

class Categoria(val nombreIU : String, val color :String ) {
    val nombre_BD : String = nombreIU.trim().lowercase()
}