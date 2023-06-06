package com.example.whochat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button log_in;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            //カメラ機能の権限チェック
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, 1);
            //許可を求める
        }

        log_in = findViewById(R.id.button_1);
        register = findViewById(R.id.button_2);

        log_in.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.button_1:
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.button_2:
                intent.setClass(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}