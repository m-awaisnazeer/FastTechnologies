package com.example.fasttechnologies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategryWebDev extends AppCompatActivity {
    Button asp,fewd,ms,php_laravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categry_web_dev);
        asp=findViewById(R.id.aspdotnet);
        fewd=findViewById(R.id.fewd);
        ms=findViewById(R.id.mern_stack);
        php_laravel=findViewById(R.id.phplaravel);
        asp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ASPdotNet.class));
            }
        });
        fewd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FrontEndWebDev.class));
            }
        });
        ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MernStack.class));
            }
        });
        php_laravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PHPLaravel.class));
            }
        });
    }
}
