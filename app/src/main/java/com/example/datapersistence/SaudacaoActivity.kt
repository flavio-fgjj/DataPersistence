package com.example.datapersistence

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*


class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        val nome = saudacaoPersistencia.getString("nome", "")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        lbSaudacao.text = if(tratamento.toString().lowercase() == "sem tratamento") nome else tratamento
    }
}