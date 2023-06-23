package org.rapturev.timerv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        val textTime = findViewById<TextView>(R.id.textTime)
        val stopButton = findViewById<Button>(R.id.stopButton)

        val maxSeconds = intent.getLongExtra("maxSeconds", 120)

        stopButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        fun startTimer() {
            object : CountDownTimer(maxSeconds * 1000, 1000) {

                // Callback function, fired on regular interval
                override fun onTick(millisUntilFinished: Long) {
                    textTime.setText("${(millisUntilFinished / 1000) + 1}")
                }

                // Callback function, fired
                // when the time is up
                override fun onFinish() {
                    textTime.setText("done!")
                }
            }.start()
        }

        startTimer()
    }


}