package com.example.fasttechnologies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class viewflipper extends AppCompatActivity {
    ViewFlipper viewFlipper;
    int[] images={R.drawable.aade,R.drawable.bc,R.drawable.ceh,R.drawable.fewd};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper=findViewById(R.id.vf);
        for(int i=0; i<images.length; i++){
            // This will create dynamic image views and add them to the viewflipper.
            setFlipperImage(images[i]);
        }
    }
    public void setFlipperImage(int img){
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(img);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(getApplicationContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getApplicationContext(),android.R.anim.slide_out_right);
    }
}
