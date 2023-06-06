package com.example.whochat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        SplashActivity.this.finish();
//                    }
//                });
//            }
//        }).start();

//        if (ContextCompat.checkSelfPermission(SplashActivity.this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
//            //カメラ機能の権限チェック
//            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{android.Manifest.permission.CAMERA}, 1);
//            //許可を求める
//        }


        Integer time = 5000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, time);
    }
}



