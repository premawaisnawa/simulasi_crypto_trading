package com.example.premawaisnawa.simulasicryptotrading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class IdrMarketActivity extends AppCompatActivity {
    TextView TvTotalCoin, TvTotalIdr, TvUntungRugi, TvPersentasi,TvTakerBeli,TvTakerJual;
    EditText EtBeliCoin, EtJumlahIdr, EtJualCoin;
    CheckBox CbTakerBeli,CbTakerJual;
    double jumlahIdr,hargaBeliCoin,totalCoin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idr_market);
        TvTotalCoin = (TextView) findViewById(R.id.tv_total_coin);
        TvTotalIdr = (TextView) findViewById(R.id.tv_total_idr);
        TvUntungRugi = (TextView) findViewById(R.id.tv_untung_rugi);
        TvPersentasi = (TextView) findViewById(R.id.tv_persentasi);
        TvTakerBeli = (TextView) findViewById(R.id.tv_taker_beli);
        TvTakerJual = (TextView) findViewById(R.id.tv_taker_jual);
        EtBeliCoin = (EditText) findViewById(R.id.et_beli_coin);
        EtJumlahIdr = (EditText) findViewById(R.id.et_jumlah_idr);
        EtJualCoin = (EditText) findViewById(R.id.et_beli_coin);
        CbTakerBeli = (CheckBox) findViewById(R.id.cb_taker_beli);
        CbTakerJual = (CheckBox) findViewById(R.id.cb_taker_jual);

        EtBeliCoin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().isEmpty()){
                    hargaBeliCoin = 0;
                }else {
                    hargaBeliCoin = Double.parseDouble(s.toString());
                }

                if( EtJumlahIdr.getText().toString().isEmpty()){
                    jumlahIdr = 0;
                }else {
                    jumlahIdr =  Double.parseDouble(EtJumlahIdr.getText().toString());
                }

                if (jumlahIdr == 0){
                    TvTotalCoin.setText(String.valueOf(0));
                }else {
                    totalCoin = jumlahIdr/hargaBeliCoin;
                    TvTotalCoin.setText(String.valueOf(totalCoin));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EtJumlahIdr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (usernameRes.equals("admin") && passwordRes.equals("admin")){
//
//                }
                if(s.toString().isEmpty() ){
                    jumlahIdr = 0;
                }else {
                    jumlahIdr =  Double.parseDouble(s.toString());
                }
                if(EtBeliCoin.getText().toString().isEmpty()){
                    hargaBeliCoin = 0;
                }else {
                    hargaBeliCoin = Double.parseDouble(EtBeliCoin.getText().toString());
                }
                if (hargaBeliCoin == 0){
                    TvTotalCoin.setText(String.valueOf(0));
                }else {
                    totalCoin = jumlahIdr/hargaBeliCoin;
                    TvTotalCoin.setText(String.valueOf(totalCoin));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });


    }
}
