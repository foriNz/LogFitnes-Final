package com.logfitness.Activities

import android.opengl.Visibility
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
import androidx.recyclerview.widget.RecyclerView.*
import com.logfitness.Activities.Dialogos.CreacionCategoria
import com.logfitness.Adaptadores.EjerciciosCompuestosAdapter_CEjercicio
import com.logfitness.BBDD.BDCategorias
import com.logfitness.Entidades.Categoria
import com.logfitness.Entidades.EjercicioCompuesto
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
    var nuevo_ejercicio_compuesto: Button? = null

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
        nuevo_ejercicio_compuesto = findViewById(R.id.btn_nuevo_ejercicio_compuesto)
        nuevo_ejercicio_compuesto!!.setOnClickListener{

        }
        ejercicio_compuesto!!.setOnClickListener {
            if (ejercicio_compuesto!!.isChecked) {
                spinner_categoria!!.visibility = (INVISIBLE)
                nuevo_ejercicio_compuesto!!.visibility = (VISIBLE)
                val bd : BDCategorias = BDCategorias(this)
                rv_ejercicios_compuestos!!.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val array : MutableList<EjercicioCompuesto> = emptyList<EjercicioCompuesto>().toMutableList()
                //array.add(Categoria(spinner_categoria!!.selectedItem.toString(), bd.getColor(spinner_categoria!!.selectedItem.toString())))
                rv_ejercicios_compuestos!!.adapter = EjerciciosCompuestosAdapter_CEjercicio(this, array)
            } else {
                spinner_categoria!!.visibility = (VISIBLE)
                nuevo_ejercicio_compuesto!!.visibility = (INVISIBLE)
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

    fun refrescarSpinnerCategorias() {
        val bd = BDCategorias(this)
        val adapter =
            ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_item, bd.getCategorias())
        spinner_categoria!!.adapter = adapter
    }
}