package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.TextInput
import tech.dalenta.component.utils.CaptionState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInputEmail = findViewById<TextInput>(R.id.text_input_email)
        textInputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    textInputEmail.setCaptionState(CaptionState.ERROR)
                    textInputEmail.textCaption = "Tulis Email yang benar"
                } else {
                    textInputEmail.setCaptionState(CaptionState.SUCCESS)
                    textInputEmail.textCaption = "Goodjob"
                }
            }
        })

        val textInputPassword = findViewById<TextInput>(R.id.text_input_password)
        textInputPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if ((s?.length ?: 0) <= 6) {
                    textInputPassword.setCaptionState(CaptionState.ERROR)
                    textInputPassword.textCaption = "Minimal password 6 ya bro"
                } else {
                    textInputPassword.setCaptionState(CaptionState.SUCCESS)
                    textInputPassword.textCaption = "Keren"
                }
            }
        })
    }
}