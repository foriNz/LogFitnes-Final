package com.logfitness.Activities.Dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDialogFragment
import com.logfitness.Activities.CreacionEjercicio
import com.logfitness.BBDD.BDCategorias
import com.logfitness.Entidades.Categoria
import com.logfitness.R
import de.hdodenhof.circleimageview.CircleImageView

class CreacionCategoria: AppCompatDialogFragment() {
    var color : String? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.dialog_creacion_categoria, null)

        val nombre_categoria: EditText = view.findViewById(R.id.et_nombre_categoria)
        val tl_colores: TableLayout = view.findViewById(R.id.tl_colores_categorias)
        rellenarColores(tl_colores)
        builder.setView(view)
        builder.setPositiveButton(resources.getString(R.string.crear_categoria)){DialogInterface, Int ->
            // TODO: verificacion de valores
            // TODO: refrescar spinner una vez se agrege categoria
            val bd : BDCategorias = BDCategorias(requireContext())
            var cat : Categoria = Categoria(nombre_categoria.text.toString(), color!!)
            bd.addCategoria(cat)
            dismiss()
            (context as CreacionEjercicio).refrescarSpinnerCategorias()
        }
        return builder.create()
    }

    private fun getColores(): Array<String> {
        return this.resources.getStringArray(R.array.colores)
    }

    private fun rellenarColores(tableLayout: TableLayout) {
        val colores: Array<String> = getColores()

        val tr = TableRow(context)
        for (i in colores.indices) {
            val inflater = this.layoutInflater
            val view: View = inflater.inflate(R.layout.view_colores, null)
            var imageView: CircleImageView = view.findViewById(R.id.civ_cardview_colores_categoria)
            imageView.getLayoutParams().height = 70
            imageView.getLayoutParams().width = 70
            val b = colores[i]
            val a = Color.parseColor(colores[i])
            imageView.setBackgroundColor(a)
            //imageView.setColorFilter(i);
            // imageView.setBackgroundColor();
            imageView.setOnClickListener(View.OnClickListener {
                // TODO: Alguna forma para mostrar el color elegido
                color = b

            })
            tr.addView(view)
        }
        tableLayout.addView(tr)
    }
}