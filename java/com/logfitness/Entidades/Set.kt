package com.logfitness.Entidades

open class Set(
    val id: Double,
    open val tipo: String = "normal",
    val repeticiones: Int,
    val lastre: Double,
    val asistidas: Int,
    val nota: String
) {

}

class Calentamiento(
    id: Double,
    repeticiones: Int,
    lastre: Double,
    asistidas: Int,
    nota: String
) : com.logfitness.Entidades.Set(
    id = id,
    tipo = "calentamiento",
    repeticiones = repeticiones,
    lastre = lastre,
    asistidas = asistidas,
    nota = nota
) {

}class Dropset(
    id: Double,
    repeticiones: Int,
    lastre: Double,
    asistidas: Int,
    nota: String
) : com.logfitness.Entidades.Set(
    id = id,
    tipo = "dropset",
    repeticiones = repeticiones,
    lastre = lastre,
    asistidas = asistidas,
    nota = nota
) {

}