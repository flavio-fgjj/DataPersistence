package com.example.datapersistence

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val db = DatabaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""

        if(cursor.count > 0) {
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }

        val aux = if (nome.isEmpty() && nome.toString() == "Sem nome") "Sem nome" else nome
        lbSaudacao.text = if(tratamento.toString().lowercase() == "sem tratamento") nome else "$tratamento $aux"
    }
}