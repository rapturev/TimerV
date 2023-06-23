//basics
package org.rapturev.timerv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private var launcher: ActivityResultLauncher<Intent>? = null
    var maxSeconds: Long? = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textTimeVar = findViewById<TextView>(R.id.textTimeVar)
        val optionsButton = findViewById<Button>(R.id.optionsButton)
        val timerButton = findViewById<Button>(R.id.timerButton)


        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                maxSeconds = result.data?.getLongExtra("maxSeconds", 120)
                textTimeVar.text = maxSeconds.toString()
            }
        }

        optionsButton.setOnClickListener {
            launcher?.launch(Intent(this, OptionsActivity::class.java))
        }
        timerButton.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("maxSeconds", maxSeconds)
            startActivity(intent)
        }
    }
}

