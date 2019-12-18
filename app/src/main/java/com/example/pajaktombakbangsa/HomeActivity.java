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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView txtHello;
    private String usernameKey;
    private String KEY_NAME = "NAMA";


    ListView listview1;
    ArrayAdapter<String>listadapter;
    String [] text1= {"USA", "Japan", "Korea", "United Kingdom", "China"};
    int [] val = {14000, 120, 21, 18000, 2000};

    Spinner sp1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        txtHello = (TextView) findViewById(R.id.txtHello);

        Bundle extras = getIntent().getExtras();
        usernameKey = extras.getString(KEY_NAME);
        txtHello.setText("Hello, " + usernameKey);


        sp1 = (Spinner)findViewById(R.id.sp1);
        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(HomeActivity.this,
                        android.R.layout.simple_spinner_item, text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(onItemSelectedListener1);

    }

    OnItemSelectedListener onItemSelectedListener1 =
            new OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item = String.valueOf(val[position]).toString();

                    Toast.makeText(parent.getContext(), "Selected: " + String.valueOf(sp1.getSelectedItem()),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) { }
            };

    public void Pindah2(View view){
        Intent intent = new Intent(HomeActivity.this, CalculatorActivity.class);
        intent.putExtra("data", String.valueOf(sp1.getSelectedItem()).toString());
        HomeActivity.this.startActivity(intent);
        finish();
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
