package com.example.premawaisnawa.simulasicryptotrading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showIdrMarket = new Intent(getApplicationContext(), IdrMarketActivity.class);
                startActivity(showIdrMarket);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showAbout = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(showAbout);
            }
        });
    }
}
