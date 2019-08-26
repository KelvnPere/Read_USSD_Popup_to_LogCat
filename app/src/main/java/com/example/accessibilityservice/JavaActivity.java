package com.example.accessibilityservice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

public class JavaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     startService(new Intent(this, UssdService.class));
        dialNumber("556");

    }

    // method for ussd
    private void dialNumber(String code) {
        String ussdCode = "*" + code + Uri.encode("#");
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ussdCode)));

        // if you decide to use "android.intent.action.DIAL" then you need to write the code for runtime permission
    }


}
