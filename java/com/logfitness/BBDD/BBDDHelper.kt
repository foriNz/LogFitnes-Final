package com.logfitness.BBDD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.annotation.Nullable


open class BBDDHelper(
    contexto: Context
) : SQLiteOpenHelper(contexto, "usuario.db", null, 1) {

    val TABLA_EJERCICIOS = "t_ejercicios"
    val TABLA_SERIES = "t_series"
    val TABLA_CATEGORIAS = "t_categorias"
    /*private val DATABASE_VERSION: Int = 1
    private val DATABASE_NAME: String = "usuario.db"*/


    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE $TABLA_CATEGORIAS (" +
                    "nombre_BD TEXT PRIMARY KEY," +
                    "nombre_IU TEXT NOT NULL, " +
                    "color TEXT NOT NULL)"
        )

        sqLiteDatabase.execSQL(
            ("CREATE TABLE $TABLA_EJERCICIOS (" +
                    "nombre_BD TEXT PRIMARY KEY," +
                    "nombre_IU TEXT NOT NULL," +
                    "categoria TEXT NOT NULL," +
                    "padre TEXT)")
        )
        sqLiteDatabase.execSQL(
            ("CREATE TABLE $TABLA_SERIES (" +
                    "id NUMERIC NOT NULL, " +
                    "fecha INTEGER NOT NULL, " +
                    "nombre_ejercicio TEXT NOT NULL, " +
                    "puesto_lista INTEGER NOT NULL, " +
                    "reps INTEGER NOT NULL, " +
                    "lastre NUMERIC NOT NULL, " +
                    "asistidas INTEGER NOT NULL, " +
                    "PRIMARY KEY(id, fecha, nombre_ejercicio))")
        )
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE if exists $TABLA_EJERCICIOS")
        sqLiteDatabase.execSQL("DROP TABLE if exists $TABLA_SERIES")
        sqLiteDatabase.execSQL("DROP TABLE if exists $TABLA_CATEGORIAS")
        onCreate(sqLiteDatabase)
    }
}