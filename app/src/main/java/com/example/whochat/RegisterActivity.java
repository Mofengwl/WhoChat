package com.example.whochat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button next;
    Button complete;

    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;

    String acc;
    String pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        next = findViewById(R.id.button_1);

        e1 = findViewById(R.id.edit_1);
        e2 = findViewById(R.id.edit_2);

        next.setOnClickListener(this);

    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.button_1:
                if (e1.getText().toString().equals("") || e2.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "アカウント/確認を入力してください", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!e1.getText().toString().equals(e2.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "アカウントが一致しません", Toast.LENGTH_SHORT).show();
                    return;
                }
                acc = e1.getText().toString();
                setContentView(R.layout.activity_register_password);
                complete = findViewById(R.id.button_2);

                e3 = findViewById(R.id.edit_3);
                e4 = findViewById(R.id.edit_4);

                complete.setOnClickListener(this);

            case R.id.button_2:
                if (e3.getText().toString().equals("") || e4.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "パスワード/確認を入力してください", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!e3.getText().toString().equals(e4.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "パスワードが一致しません", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, "登録完了", Toast.LENGTH_SHORT).show();
                pas = e3.getText().toString();

                SharedPreferences users = getSharedPreferences("users", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = users.edit();
                editor.putString("account", acc);
                editor.putString("password", pas);
                editor.commit();
                intent.setClass(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
        }
    }
}
