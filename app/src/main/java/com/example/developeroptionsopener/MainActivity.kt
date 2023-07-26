package com.example.developeroptionsopener

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openSettings()
    }

    private fun openSettings() {

        if (Settings.Secure.getInt(this.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0) {
            try {
                val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                Toast
                    .makeText(this, e.toString(), Toast.LENGTH_LONG)
                    .show()
                finish()
            }
        } else {
            Toast
                .makeText(this, "Dev options disabled!", Toast.LENGTH_LONG)
                .show()
            val intent = Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

    }

}
