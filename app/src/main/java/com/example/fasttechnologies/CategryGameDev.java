package com.example.fasttechnologies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategryGameDev extends AppCompatActivity {
    Button tdgwu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categry_game_dev);
        tdgwu=findViewById(R.id.udwtd);
        tdgwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),GameDevUnityTD.class));
            }
        });
    }
}
