package com.example.pajaktombakbangsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView txtHello;
    private String usernameKey;
    private String KEY_NAME = "NAMA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtHello = (TextView) findViewById(R.id.txtHello);

        Bundle extras = getIntent().getExtras();
        usernameKey = extras.getString(KEY_NAME);
        txtHello.setText("Hello, " + usernameKey);
    }

    public void Pindah2(View view){

        Intent intent = new Intent(HomeActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.home){
            startActivity(new Intent(this, HomeActivity.class));
        } else if (item.getItemId() == R.id.Logout) {
            startActivity(new Intent(this, MainActivity.class));
        }

        return true;
    }
}
