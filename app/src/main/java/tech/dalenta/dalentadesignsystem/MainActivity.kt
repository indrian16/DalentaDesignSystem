package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<TextInput>(R.id.text_input)
        textInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    textInput.textLabel.text = s.toString()
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        findViewById<SmallButtonPrimary>(R.id.btn_small_primary).apply {
            setOnClickListener {
                Toast.makeText(it.context, "SmallButtonPrimary", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<SmallButtonSecondary>(R.id.btn_small_secondary).apply {
            setOnClickListener {
                Toast.makeText(it.context, "SmallButtonSecondary", Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<SmallButtonOutlined>(R.id.btn_small_outlined).apply {
            //button.text = "SmallButtonOutlined Edited"
            setOnClickListener {
                Toast.makeText(it.context, "SmallButtonOutlined", Toast.LENGTH_SHORT).show()
            }
        }

//        findViewById<LargeButtonPrimary>(R.id.btn_large_primary).apply {
//            setOnClickListener {
//                Toast.makeText(it.context, "LargeButtonPrimary", Toast.LENGTH_SHORT).show()
//            }
//        }
//        findViewById<LargeButtonSecondary>(R.id.btn_large_secondary).apply {
//            setOnClickListener {
//                Toast.makeText(it.context, "LargeButtonSecondary", Toast.LENGTH_SHORT).show()
//            }
//        }
        findViewById<LargeButtonOutlined>(R.id.btn_large_outlined).apply {
            setOnClickListener {
                Toast.makeText(it.context, "LargeButtonOutlined", Toast.LENGTH_SHORT).show()
            }
        }
    }
}