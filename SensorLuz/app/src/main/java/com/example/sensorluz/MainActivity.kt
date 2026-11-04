package com.example.sensorluz

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensorLuz: Sensor? = null
    private lateinit var layout: LinearLayout
    private lateinit var tvTitulo: TextView
    private lateinit var tvModo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.layout)
        tvTitulo = findViewById(R.id.tvTitulo)
        tvModo = findViewById(R.id.tvModo)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorLuz?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        val luz = event.values[0]
        when {
            luz < 50 -> aplicarModo(true)
            luz > 500 -> aplicarModo(false)
        }
    }

    private fun aplicarModo(oscuro: Boolean) {
        val fondo = if (oscuro) Color.BLACK else Color.WHITE
        val texto = if (oscuro) Color.WHITE else Color.BLACK
        layout.setBackgroundColor(fondo)
        tvTitulo.setTextColor(texto)
        tvModo.setTextColor(texto)
        tvModo.setText(if (oscuro) R.string.modo_oscuro else R.string.modo_claro)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
