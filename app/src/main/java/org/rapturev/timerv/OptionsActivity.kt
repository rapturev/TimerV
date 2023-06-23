package org.rapturev.timerv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val returnButton = findViewById<Button>(R.id.returnButton)

        returnButton.setOnClickListener {
            // Validation
            if (TextUtils.isEmpty(editTextTime.text.toString())) {
                Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
            } else {
                val maxSeconds = editTextTime.text.toString().toLong()
                val intent = Intent()
                intent.putExtra("maxSeconds", maxSeconds)
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }
}