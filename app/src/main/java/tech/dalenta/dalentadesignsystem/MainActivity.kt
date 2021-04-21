package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.TextInput
import tech.dalenta.component.utils.CaptionState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputEmail = findViewById<TextInput>(R.id.text_input_email)


        textInputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    textInputEmail.setCaptionState(CaptionState.ERROR)
                    textInputEmail.textCaption = "Email tidak boleh kosong"
                } else {
                    textInputEmail.setCaptionState(CaptionState.SUCCESS)
                    textInputEmail.textCaption = "Mantap"
                }
            }
        })

        val textInputPassword = findViewById<TextInput>(R.id.text_input_password)
    }
}