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
    private EditText edtharga, edtongkir, edtasuransi;
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
        btnproses = (Button) findViewById(R.id.proses);
        txtharga = (TextView) findViewById(R.id.hargabarang);
        txtongkir = (TextView) findViewById(R.id.hargaongkir);
        txtasuransi = (TextView) findViewById(R.id.hargaasuransi);
        txtkurs = (TextView) findViewById(R.id.kurs);
        Bundle bundle=getIntent().getExtras();
        final String data=bundle.get("data").toString();
        if(data.equals("USA")) {
            txtkurs.setText("Kurs: 14000");
        }else if (data.equals("Japan")){
            txtkurs.setText("Kurs: 120");
        }else if (data.equals("Korea")){
            txtkurs.setText("Kurs: 24");
        } else if (data.equals("United Kingdom")) {
            txtkurs.setText("Kurs: 18000");
        }else {
            txtkurs.setText("Kurs: 2000");
        }
        txtpajak = (TextView) findViewById(R.id.hargapajak);




        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hargabarang = edtharga.getText().toString().trim();
                String hargaongkir= edtongkir.getText().toString().trim();
                String hargaasuransi = edtasuransi.getText().toString().trim();
                int hargakurs;
                if (data.equals("USA")){
                    hargakurs = 14000;
                }else if (data.equals("Japan")){
                    hargakurs = 120;
                }else if (data.equals("Korea")){
                    hargakurs = 24;
                }else if (data.equals("United Kingdom")){
                    hargakurs = 18000;
                }else{
                    hargakurs = 2000;
                }


                double hb = Double.parseDouble(hargabarang);
                double ho = Double.parseDouble(hargaongkir);
                double ha = Double.parseDouble(hargaasuransi);
                double totaltransaksi = (hb + ho + ha);
                double hargapajak = (totaltransaksi * 0.075 * hargakurs);
                txtpajak.setText("Harga Pajak yang harus dibayar: Rp " + hargapajak);


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