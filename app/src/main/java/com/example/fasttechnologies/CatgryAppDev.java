package com.example.fasttechnologies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CatgryAppDev extends AppCompatActivity {
    Button android;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgry_app_dev);
        android=findViewById(R.id.android);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CatgryAppDev.this,AndroidAppDev.class));
            }
        });
    }
}
