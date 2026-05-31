package com.example.dialogosnotificaciones

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnSnackBar = findViewById<Button>(R.id.btnSnackBar)
        val btnDialog = findViewById<Button>(R.id.btnDialog)
        val btnProgress = findViewById<Button>(R.id.btnProgress)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // TOAST
        btnToast.setOnClickListener {
            Toast.makeText(
                this,
                "Hola, este es un Toast",
                Toast.LENGTH_SHORT
            ).show()
        }

        // SNACKBAR
        btnSnackBar.setOnClickListener {
            Snackbar.make(
                it,
                "Mensaje SnackBar",
                Snackbar.LENGTH_LONG
            )
                .setAction("Deshacer") {
                    Toast.makeText(
                        this,
                        "Acción realizada",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show()
        }

        // ALERTDIALOG
        btnDialog.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Deseas continuar?")
                .setPositiveButton("Aceptar") { dialog, _ ->
                    Toast.makeText(
                        this,
                        "Aceptaste",
                        Toast.LENGTH_SHORT
                    ).show()
                    dialog.dismiss()
                }
                .setNegativeButton("Cancelar") { dialog, _ ->
                    Toast.makeText(
                        this,
                        "Cancelaste",
                        Toast.LENGTH_SHORT
                    ).show()
                    dialog.dismiss()
                }
                .show()
        }

        // PROGRESSBAR
        btnProgress.setOnClickListener {

            progressBar.visibility = ProgressBar.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({

                progressBar.visibility = ProgressBar.GONE

                Toast.makeText(
                    this,
                    "Carga completada",
                    Toast.LENGTH_SHORT
                ).show()

            }, 3000)
        }
    }
}