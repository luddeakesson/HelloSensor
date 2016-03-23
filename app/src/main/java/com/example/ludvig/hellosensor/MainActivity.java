package com.example.ludvig.hellosensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView kompass, accelerometer;
    private TextView accelerometer1, compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kompass = (ImageView)findViewById(R.id.kompass_button);
        accelerometer =(ImageView)findViewById(R.id.accelerometer_button);
        accelerometer1 =(TextView)findViewById(R.id.accelerometer_text);
        compass = (TextView)findViewById(R.id.compass_text);

        kompass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Kompass.class));
            }
        });


        accelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Accelerometer.class));
            }
        });

    }
}
