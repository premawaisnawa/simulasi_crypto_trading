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
    double jumlahIdr,hargaBeliCoin, hargaJualCoin, totalCoin, totalIdr;

    public double getJumlahIdr() {
        return jumlahIdr;
    }

    public void setJumlahIdr(double jumlahIdr) {
        this.jumlahIdr = jumlahIdr;
    }

    public double getHargaBeliCoin() {
        return hargaBeliCoin;
    }

    public void setHargaBeliCoin(double hargaBeliCoin) {
        this.hargaBeliCoin = hargaBeliCoin;
    }

    public double getHargaJualCoin() {
        return hargaJualCoin;
    }

    public void setHargaJualCoin(double hargaJualCoin) {
        this.hargaJualCoin = hargaJualCoin;
    }

    public double getTotalCoin() {
        return totalCoin;
    }

    public void hitungTotalCoin() {
        this.totalCoin = this.jumlahIdr/this.hargaBeliCoin;
    }

    public double getTotalIdr() {
        return totalIdr;
    }

    public void hitungTotalIdr() {
        this.totalIdr = this.totalCoin * this.hargaJualCoin;
    }

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
                setHargaBeliCoin(hargaBeliCoin);
                hitungTotalCoin();
                TvTotalCoin.setText(String.valueOf(getTotalCoin()));
                TvTotalIdr.setText(String.valueOf(getTotalIdr()));

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

                if(s.toString().isEmpty() ){
                    jumlahIdr = 0;
                }else {
                    jumlahIdr =  Double.parseDouble(s.toString());
                }
                setJumlahIdr(jumlahIdr);
                hitungTotalCoin();
                hitungTotalIdr();
                TvTotalCoin.setText(String.valueOf(getTotalCoin()));
                TvTotalIdr.setText(String.valueOf(getTotalIdr()));
            }
            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        EtJualCoin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().isEmpty() ){
                    hargaJualCoin = 0;
                }else {
                    hargaJualCoin =  Double.parseDouble(s.toString());
                }
                setHargaJualCoin(hargaJualCoin);
                hitungTotalCoin();
                hitungTotalIdr();
                double coin = Double.parseDouble(TvTotalCoin.getText().toString());
                double totidr = coin   *hargaJualCoin;
                TvTotalIdr.setText(String.valueOf(totidr));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
