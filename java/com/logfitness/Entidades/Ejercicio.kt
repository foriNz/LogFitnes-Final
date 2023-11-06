package com.logfitness.Entidades

class Ejercicio (val nombreIU : String, val categoria: String, val padre :String? ){
    val nombre_BD : String = nombreIU.lowercase().trim()
    var categorias_compuestas : MutableList<EjercicioCompuesto>? = null
    constructor( nombreIU : String, categoria: String, padre :String?, categorias_compuestas: MutableList<EjercicioCompuesto> ) : this(nombreIU, categoria, padre) {
        this.categorias_compuestas = categorias_compuestas
    }
}