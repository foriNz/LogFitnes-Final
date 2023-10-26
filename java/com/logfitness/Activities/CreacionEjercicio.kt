package com.logfitness.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.logfitness.Activities.Dialogos.CreacionCategoria
import com.logfitness.BBDD.BDCategorias
import com.logfitness.Entidades.Categoria
import com.logfitness.R

class CreacionEjercicio : AppCompatActivity() {
    var dialogo_nueva_categoria: CreacionCategoria? = null
    var editText: EditText? = null
    var spinner_categoria: Spinner? = null
    var rv_ejercicios_compuestos: RecyclerView? = null
    var ayuda_ejercicio_padre: Button? = null
    var spinner_ejercicio_padre: Spinner? = null
    var ejercicio_compuesto: CheckBox? = null
    var ayuda_ejercicio_compuesto: Button? = null

    var al_ejercicios_compuestos : MutableList<Categoria> = emptyList<Categoria>().toMutableList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creacion_ejercicio)
        val searchView: SearchView = findViewById(R.id.sv_buscador_ejercicio_padre)
        searchView.queryHint = resources.getString(R.string.hint_buscador_ejercicio_padre)
        editText = findViewById(R.id.et_titulo_ejercicio)
        spinner_categoria = findViewById(R.id.sp_categoria)
        val nueva_categoria: Button = findViewById(R.id.btn_nueva_categoria_CE)
        ayuda_ejercicio_padre = findViewById(R.id.btn_ayuda_ejercicio_padre)
        rv_ejercicios_compuestos = findViewById(R.id.rv_ejercicios_compuestos)
        spinner_ejercicio_padre = findViewById(R.id.sp_ejercicio_padre)
        ejercicio_compuesto = findViewById(R.id.cb_ejercicio_compuesto)
        ayuda_ejercicio_compuesto = findViewById(R.id.btn_ayuda_ejercicio_compuesto)
        ejercicio_compuesto!!.setOnClickListener {
            if (ejercicio_compuesto!!.isSelected) {
                rv_ejercicios_compuestos!!.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                var array : MutableList<Categoria> = emptyList<Categoria>().toMutableList()
                array.add(Categoria(spinner_categoria!!.selectedItem.toString(),))



            }
        }
        nueva_categoria.setOnClickListener { abrirNuevaCategoria() }
        refrescarSpinnerCategorias()
    }

    private fun abrirNuevaCategoria() {
        val dialogo = CreacionCategoria()
        dialogo_nueva_categoria = dialogo
        dialogo_nueva_categoria!!.isCancelable = false
        dialogo_nueva_categoria!!.show(supportFragmentManager, "dialogo_categoria")
    }

    public fun refrescarSpinnerCategorias() {
        val bd = BDCategorias(this)
        val adapter =
            ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_item, bd.getCategorias())
        spinner_categoria!!.adapter = adapter
    }
}