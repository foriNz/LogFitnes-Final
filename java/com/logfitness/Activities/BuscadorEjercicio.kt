package com.logfitness.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.logfitness.Adaptadores.ListaEjerciciosAdapter_BE
import com.logfitness.BBDD.BDEjercicios
import com.logfitness.Entidades.Categoria
import com.logfitness.Entidades.Ejercicio
import com.logfitness.R

class BuscadorEjercicio : AppCompatActivity(), SearchView.OnQueryTextListener  {
    var nuevo_ejercicio: Button? = null
    var buscador: SearchView? = null
    var rv_ejercicios: RecyclerView? = null
    var btn_atras: Button? = null
    var listaArrayEjercicios: MutableList<Ejercicio> = emptyList<Ejercicio>().toMutableList()
    var adapter: ListaEjerciciosAdapter_BE? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador_ejercicio)
        nuevo_ejercicio = findViewById(R.id.btn_nuevoEjercicio_BE)
        btn_atras = findViewById(R.id.btn_atras_BE)
        buscador = findViewById(R.id.buscador_ejercicio)
        rv_ejercicios = findViewById(R.id.rvLista_ejercicios)
        btn_atras!!.setOnClickListener{finish()}
        nuevo_ejercicio!!.setOnClickListener({startActivity(Intent(baseContext, CreacionEjercicio::class.java)) })
        agregarDatosRecyclerView()
    }

    private fun agregarDatosRecyclerView() {
        rv_ejercicios!!.setLayoutManager(LinearLayoutManager(this))
        val bdEjercicios = BDEjercicios(this)
        listaArrayEjercicios = ArrayList()
        adapter =
            ListaEjerciciosAdapter_BE(bdEjercicios.getEjercicios(), this)
        rv_ejercicios!!.setAdapter(adapter)

        buscador!!.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter!!.filtrado(newText)
        return false
    }

}