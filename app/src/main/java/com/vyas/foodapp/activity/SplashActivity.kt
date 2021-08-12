package com.vyas.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import com.vyas.foodapp.R
import com.vyas.foodapp.util.ConnectionManager

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if(ConnectionManager().checkConnectivity(this)){
                val startAct = Intent(this@SplashActivity,
                    LoginActivity::class.java)
                startActivity(startAct)
                finish()
            } else {
                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("ERROR")
                dialog.setMessage("Internet Connection Not Found")
                dialog.setPositiveButton("Open Settings"){text, listener ->
                    val settingIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivity(settingIntent)
                    finish()
                }
                dialog.setNegativeButton("Cancel"){text, listener ->
                    finish()
                }
                dialog.create().show()
            }
        },1500)
    }
}
