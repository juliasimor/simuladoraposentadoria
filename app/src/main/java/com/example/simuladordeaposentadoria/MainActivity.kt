package com.example.simuladordeaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simuladordeaposentadoria.databinding.ActivityMainBinding


const val indiceMasculino = 65
const val indiceFeminino = 62
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //dados para o Spinner
        val Items = listOf("Masculino", "Feminino")

        //atribuindo a lista ao adapter
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Items)

        binding.spinnerGenero.adapter = adapter

        //acionando o evento
        binding.buttonCalcular.setOnClickListener {
            val generoSelecionado = binding.spinnerGenero.selectedItem as String
            val idade = binding.editTextIdade.text.toString().toLongOrNull()

            var resultado: Long = 0L

            if (idade != null) {

                //masculino
                if(generoSelecionado.trim() == "Masculino"){
                    resultado == indiceMasculino - idade
                }else{
                    resultado == indiceFeminino - idade
                }
                binding.textViewResultado.text = "Faltam $resultado anos para você se aposentar"

            }else{
                binding.textViewResultado.text = "Informe uma idade"
            }

        }
    }
}