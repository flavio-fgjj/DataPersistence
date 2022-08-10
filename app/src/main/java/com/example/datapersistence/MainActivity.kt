package com.example.datapersistence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener(View.OnClickListener {
            val data = "${txtNome.text.toString()}:${listTratamento.selectedItem.toString()}"
            gravacaoDadoArquivo("saudacao",  data)
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()
        })

        btnExibir.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }

    fun gravacaoDadoArquivo(filename: String, data: String) {
        try {
            val fs = openFileOutput(filename, Context.MODE_PRIVATE)
            fs.write(data.toByteArray())
            fs.close()
        } catch (e: FileNotFoundException) {
            Log.i("gravaDadoArquivo", "FileNotFoundException")
        } catch (e: IOException) {
            Log.i("gravaDadoArquivo", "IOException")
        }

    }
}


