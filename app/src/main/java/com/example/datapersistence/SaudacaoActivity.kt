package com.example.datapersistence

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*


class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val data = recuperacaoDadoArquivo("saudacao")
        val tokenizer = StringTokenizer(data, ":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem tratamento"

        lbSaudacao.text = if(tratamento.toString().lowercase() == "sem tratamento") nome else tratamento
    }

    fun recuperacaoDadoArquivo(filename: String): String {
        try {
            val fi = openFileInput(filename)
            val data = fi.readBytes()

            fi.close()

            data.toString()
            return data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            return ""
        } catch (e: IOException) {
            return ""
        }
    }

}