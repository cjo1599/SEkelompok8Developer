package com.example.pajaktombakbangsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private EditText edtharga, edtongkir, edtasuransi, edtkurs;
    private Button btnproses;
    private TextView txtharga;
    private TextView txtongkir;
    private TextView txtasuransi;
    private TextView txtkurs;
    private TextView txtpajak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        getSupportActionBar().setTitle("Tombak Pajak Bangsa");

        edtharga = (EditText) findViewById(R.id.hargabarang);
        edtongkir = (EditText) findViewById(R.id.hargaongkir);
        edtasuransi = (EditText) findViewById(R.id.hargaasuransi);
        edtkurs = (EditText) findViewById(R.id.kurs);
        btnproses = (Button) findViewById(R.id.proses);
        txtharga = (TextView) findViewById(R.id.hargabarang);
        txtongkir = (TextView) findViewById(R.id.hargaongkir);
        txtasuransi = (TextView) findViewById(R.id.hargaasuransi);
        txtkurs = (TextView) findViewById(R.id.kurs);
        txtpajak = (TextView) findViewById(R.id.hargapajak);


        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargabarang = edtharga.getText().toString().trim();
                String hargaongkir= edtongkir.getText().toString().trim();
                String hargaasuransi = edtasuransi.getText().toString().trim();
                String kurs = edtkurs.getText().toString().trim();

                double hb = Double.parseDouble(hargabarang);
                double ho = Double.parseDouble(hargaongkir);
                double ha = Double.parseDouble(hargaasuransi);
                double k = Double.parseDouble(kurs);
                double hargapajak = (hb * ho + ha  * 0.75 * k);
                txtpajak.setText("Harga Pajak yang harus dibayar: " + hargapajak);


            }
        });

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