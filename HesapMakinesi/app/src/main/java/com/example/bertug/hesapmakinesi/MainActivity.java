package com.example.bertug.hesapmakinesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editSayi;

    public enum Islem{
        topla,
        cikar,
        carp,
        bol
    }

    float sonuc = 0;
    public Islem seciliIslem= null;

    public boolean temizle = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    editSayi = (EditText) findViewById(R.id.sonucTxt);

    Button sil = (Button) findViewById(R.id.silBttn);

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            editSayi.setText("0");
            seciliIslem =null;
            }
        });

    }

    public void SayiYaz(View v){
        Button b = (Button) v;

        if (editSayi.getText().toString().equals("0")){
            editSayi.setText("");
        }
        if (temizle){
            editSayi.setText("");
            temizle = false;
        }

        editSayi.setText(editSayi.getText().toString() + b.getText().toString());
    }

    public void dortIslem(View v){

    Float gelenSayi = Float.valueOf(editSayi.getText().toString());

    if(seciliIslem == null){
        sonuc = gelenSayi;
    }else{
        if (seciliIslem == Islem.topla){
            sonuc += gelenSayi;
        }else if (seciliIslem == Islem.cikar){
            sonuc -= gelenSayi;
        }else if (seciliIslem == Islem.carp){
            sonuc *= gelenSayi;
        }else if (seciliIslem == Islem.bol){
            sonuc /= gelenSayi;
        }
    }

    Button b = (Button) v;

        switch (b.getId()){
            case R.id.artiBttn:
                seciliIslem = Islem.topla;
                temizle = true;
                break;
            case R.id.cikarBttn:
                seciliIslem = Islem.cikar;
                temizle = true;
                break;
            case R.id.bolBttn:
                seciliIslem = Islem.bol;
                temizle = true;
                break;
            case R.id.carpBttn:
                seciliIslem = Islem.carp;
                temizle = true;
                break;
            case R.id.esittirBttn:
                editSayi.setText(String.valueOf(sonuc));
                seciliIslem= null;
                break;

        }
    }
}
