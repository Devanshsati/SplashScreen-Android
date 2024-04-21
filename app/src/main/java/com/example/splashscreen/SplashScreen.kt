@file:Suppress("DEPRECATION")

package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Handler(Looper.getMainLooper()).postDelayed({
//          startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }, 2000)
        startHeavyTask()
    }

    private fun startHeavyTask() {
        LongOperation().execute()
    }

    @SuppressLint("StaticFieldLeak")
    private open inner class LongOperation : AsyncTask<String?, Void?, String>(){
        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg params: String?): String {
            var value = true
            while (value){
                try {
                    Thread.sleep(3000)
                    value = false
                }catch (e:Exception){
                    Thread.interrupted()
                }
            }
            return "Result"
        }

        @Deprecated("Deprecated in Java")
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
        }
    }
}