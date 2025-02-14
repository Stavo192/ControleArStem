package com.example.controlear

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Classe para controlar o ar-condicionado
class ControleArActivity : AppCompatActivity() {
    // Variável para armazenar o estado do ar-condicionado (Ligado ou Desligado)
    private var ligado = false

    // Variável para armazenar a temperatura atual (padrão: 16°C)
    private var temperaturaAtual = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controle_ar) // Define o layout XML para esta tela

        // Referência para os elementos da interface
        val txtModelo = findViewById<TextView>(R.id.txt_modelo)
        val txtEstado = findViewById<TextView>(R.id.txt_estado)
        val btnLigarDesligar = findViewById<Button>(R.id.btn_ligar_desligar)
        val seekTemperatura = findViewById<SeekBar>(R.id.seek_temperatura)
        val txtTemperatura = findViewById<TextView>(R.id.txt_temperatura)

        // Define o modelo do ar-condicionado (exemplo fixo, pode ser dinâmico)
        txtModelo.text = "Modelo: LG Dual Inverter"

        // Define a temperatura mínima da SeekBar (16°C) e a máxima (30°C)
        seekTemperatura.max = 14 // Como a base começa em 16, o máximo é 14 (16+14=30)

        // Atualiza a temperatura conforme o usuário move a barra
        seekTemperatura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                temperaturaAtual = 16 + progress // Ajusta a temperatura mínima
                txtTemperatura.text = "Temperatura: $temperaturaAtual°C"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Botão para ligar/desligar o ar-condicionado
        btnLigarDesligar.setOnClickListener {
            ligado = !ligado // Inverte o estado atual (de ligado para desligado e vice-versa)
            
            // Atualiza a interface conforme o estado
            if (ligado) {
                txtEstado.text = "Status: Ligado"
                btnLigarDesligar.text = "Desligar"
            } else {
                txtEstado.text = "Status: Desligado"
                btnLigarDesligar.text = "Ligar"
            }
        }
    }
}
