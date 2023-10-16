package com.logfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.R

class CreacionEjercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacion_ejercicio)
        val searchView: SearchView = findViewById(R.id.sv_buscador_ejercicio_padre)
        searchView.queryHint = resources.getString(R.string.hint_buscador_ejercicio_padre)

    }
}