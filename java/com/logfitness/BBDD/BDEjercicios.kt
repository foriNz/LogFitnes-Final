package com.logfitness.BBDD

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.logfitness.Entidades.Categoria
import com.logfitness.Entidades.Ejercicio


class BDEjercicios (val contexto : Context): BBDDHelper(contexto) {
    fun addEjercicio(ejercicio: Ejercicio) {
        try {
            val bd: SQLiteDatabase = this.writableDatabase
            val values = ContentValues()
            values.put("nombre_BD", ejercicio.nombre_BD)
            values.put("nombre_IU", ejercicio.nombreIU)
            values.put("padre", ejercicio.padre)
            values.put("categoria", ejercicio.categoria)
            bd.insert(TABLA_EJERCICIOS, null, values)
        } catch (e: Exception) {
            e.toString()
        }

    }
    fun getEjercicios(): MutableList<Ejercicio> {
        var resultado: MutableList<Ejercicio> = emptyList<Ejercicio>().toMutableList()
        return resultado
    }
}