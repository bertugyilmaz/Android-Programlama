package com.example.bertug.intent_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button geridonBttn = (Button)findViewById(R.id.bttn2);
        geridonBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);

                Main2Activity.this.startActivity(intent);
                Main2Activity.this.finish();
            }
        });
    }
}
