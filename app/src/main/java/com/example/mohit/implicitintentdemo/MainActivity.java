package com.example.mohit.implicitintentdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bttn, btncall;
    EditText enumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttn = findViewById(R.id.btnweb);
        enumber = findViewById(R.id.edtnumb);
        btncall = findViewById(R.id.btncall);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/dir///@31.3007298,75.5567821,15z"));
                startActivity(intent);
            }
        });

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Call", Toast.LENGTH_SHORT).show();
                String mob = enumber.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + mob));

                /*if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    return;
                 }*/

                startActivity(intent);

            }
        });
    }
}
