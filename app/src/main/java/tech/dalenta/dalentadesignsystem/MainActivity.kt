package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.TextInput
import tech.dalenta.component.utils.CaptionState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<TextInput>(R.id.text_input)
        textInput.setCaptionState(CaptionState.ERROR)
        textInput.textCaption = "Error nih"
    }
}