package com.example.pajaktombakbangsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.EncryptedPrivateKeyInfo;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText ed1, ed2;

    private String KEY_NAME = "NAMA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.login);

        ed1 = (EditText) findViewById(R.id.userinput);

        ed2 = (EditText) findViewById(R.id.passinput);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = ed1.getText().toString();
                String passwordKey = ed2.getText().toString();

                if (usernameKey != null && usernameKey != "" && passwordKey.equals("Tombakbangsa")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra(KEY_NAME, usernameKey);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else {
                    //jika login gagal

                    Toast.makeText(getApplicationContext(), "Username atau Password Anda Salah",
                            Toast.LENGTH_LONG).show();;
                }
            }

        });

    }


}