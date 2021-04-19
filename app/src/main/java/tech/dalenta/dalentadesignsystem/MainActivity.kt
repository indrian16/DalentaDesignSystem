package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.SmallButtonPrimary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<SmallButtonPrimary>(R.id.btn_small)
        Toast.makeText(baseContext, button.text, Toast.LENGTH_SHORT).show()
        button.text = "Hello World"
        Toast.makeText(baseContext, button.text, Toast.LENGTH_SHORT).show()
    }
}