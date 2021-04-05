package tech.dalenta.dalentadesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import tech.dalenta.component.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_test).setOnClickListener {
            Toast.makeText(it.context, "Hello Component", Toast.LENGTH_SHORT).show()
        }
    }
}