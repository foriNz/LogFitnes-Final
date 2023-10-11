package com.logfitness.BBDD

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.logfitness.Entidades.Ejercicio


class BDEjercicios (val contexto : Context): BBDDHelper(contexto) {
    fun addEjercicio(ejercicio: Ejercicio) {
        try {
            val bd: SQLiteDatabase = this.writableDatabase
            val values = ContentValues()
            values.put("nombre_BD", ejercicio.nombre_BD)
            values.put("nombre_IU", ejercicio.nombreIU)
            values.put("categoria", ejercicio.categoria)
            values.put("padre", ejercicio.padre)
            bd.insert(TABLA_EJERCICIOS, null, values)
        } catch (e: Exception) {
            e.toString()
        }

    }
}