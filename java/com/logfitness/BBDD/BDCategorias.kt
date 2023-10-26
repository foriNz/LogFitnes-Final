package com.logfitness.BBDD

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.logfitness.Entidades.Categoria

class BDCategorias(val contexto : Context): BBDDHelper(contexto) {
    val helper : BBDDHelper = BBDDHelper(contexto)
    fun addCategoria(categoria: Categoria) {
        try {
            val bd: SQLiteDatabase = this.writableDatabase
            val values = ContentValues()
            values.put("nombre_BD", categoria.nombre_BD)
            values.put("nombre_IU", categoria.nombreIU)
            values.put("color", categoria.color)
            bd.insert(TABLA_CATEGORIAS, null, values)
        } catch (e: Exception) {
            e.toString()
        }
    }
    fun getCategorias(): ArrayList<Categoria> {
        val bd : SQLiteDatabase = helper.readableDatabase
        var cat: Categoria?
        val categorias : ArrayList<Categoria> = ArrayList()
        val cursorCategoria = bd.rawQuery(
            "SELECT * FROM $TABLA_CATEGORIAS",
            null
        )
        if (cursorCategoria.moveToFirst()) {
            do {
                cat = Categoria(
                    cursorCategoria.getString(1),
                    cursorCategoria.getString(2)
                )
                categorias.add(cat)
            } while (cursorCategoria.moveToNext())
        }
        cursorCategoria.close()
        return categorias
    }
    fun getColor(nombre_categoria : String) : String {
        val bd : SQLiteDatabase = helper.readableDatabase
        var resultado : String = ""
        val cursorCategoria = bd.rawQuery(
            "SELECT * FROM $TABLA_CATEGORIAS WHERE nombre_BD = \'"+ nombre_categoria.trim().lowercase()+"\'",
            null
        )
        if (cursorCategoria.moveToFirst())
                resultado = cursorCategoria.getString(2)

        bd.close()
        return resultado
    }
}