package com.example.accessibilityservice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.HashMap
import android.R.attr.showText
import android.content.BroadcastReceiver
import android.content.Context
import android.util.Log
import android.content.IntentFilter

class KotlinActivity : AppCompatActivity() {
    // create an hashmap
    internal var transactionMessage = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

     startService(Intent(this, UssdService::class.java))
        // you can change this to any network provider
        // i used MTN to check balance
        dialNumber("556")

    }

    // method for ussd
    private fun dialNumber(code: String) {
        val ussdCode = "*" + code + Uri.encode("#")
        startActivity(Intent("android.intent.action.DIAL", Uri.parse("tel:$ussdCode")))

    }

}
