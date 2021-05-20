package tech.dalenta.dalentadesignsystem

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import tech.dalenta.component.LargeButtonPrimary
import tech.dalenta.component.SelectField
import tech.dalenta.component.TextInput
import tech.dalenta.component.utils.CaptionState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         *
         * Select Field Example
         * */
//        val selectField = findViewById<SelectField>(R.id.select_field)
//        selectField.setOnClickListener {
//            selectField.setSelectValue("Jakarta")
//            selectField.setCaptionState(CaptionState.SUCCESS)
//            selectField.textCaption = "Berhasil"
//        }

        /**
         *
         * Search Bar Example
         * */
//        val textSearchValue = findViewById<TextView>(R.id.text_search_value)
//        val searchBar = findViewById<SearchBar>(R.id.search_bar)
//
//        // With Watch Text Listener
//        searchBar.watchTextChange(object : WatchTextListener {
//            override fun onTextChanged(value: String, start: Int, before: Int, count: Int) {
//                textSearchValue.text = value
//            }
//        })

        // With Text Watcher
//        searchBar.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                if (s != null) {
//                    textSearchValue.text = s.toString()
//                }
//            }
//            override fun afterTextChanged(s: Editable?) {}
//        })


        /**
         *
         * Login Example
         * */
        val buttonLogin = findViewById<LargeButtonPrimary>(R.id.btn_login)
        val textInputEmail = findViewById<TextInput>(R.id.text_input_email)
        textInputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    textInputEmail.setCaptionState(CaptionState.ERROR)
                    textInputEmail.textCaption = "Tulis Email yang benar"
                    buttonLogin.isEnabled = false
                } else {
                    textInputEmail.setCaptionState(CaptionState.SUCCESS)
                    textInputEmail.textCaption = "Goodjob"
                    buttonLogin.isEnabled = true
                }
            }
        })

        val textInputPassword = findViewById<TextInput>(R.id.text_input_password)
        textInputPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if ((s?.length ?: 0) <= 6) {
                    textInputPassword.setCaptionState(CaptionState.ERROR, "Minimal password 6 ya bro")
                } else {
                    textInputPassword.setCaptionState(CaptionState.SUCCESS, "Keren")
                }
            }
        })

        val textInputAge = findViewById<TextInput>(R.id.text_input_age)
        textInputAge.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

                if (!s.isNullOrEmpty()) {
                    if (s.toString().toLong() < 18 ) {
                        textInputAge.setCaptionState(CaptionState.WARING, "Ih muda nya kamu")
                    } else {
                        textInputAge.setCaptionState(CaptionState.SUCCESS, "Udah mulai dewasa ya")
                    }
                }
            }
        })
    }
}