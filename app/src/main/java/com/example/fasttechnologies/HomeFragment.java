package com.example.fasttechnologies;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class HomeFragment extends Fragment {
    ImageView fewd;
    StorageReference imageRef;
    ViewFlipper viewFlipper;
    Button web_dev_btn,app_dev_btn,game_dev_btn,itnsoft_btn,graphic_disg_btn,pro_lang_btn,net_btn;
    TextView fewd_text;
    TextView php_text,pwd_text,aspdotnet_text,android1_text,android2_text,unity1_text,unity2_text,pythonprograming_text;

    Firebase fewd_url,php_url,pwd_url,aspdotnet_url,android1_url,android2_url,unity1_url,unity2_url,pythonprograming_url;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment,container,false);
        viewFlipper = rootView.findViewById(R.id.ViewFlipper2);
        fewd_text = rootView.findViewById(R.id.webevent1text);
        php_text=rootView.findViewById(R.id.webevent2text);
        pwd_text=rootView.findViewById(R.id.webevent3text);
        aspdotnet_text=rootView.findViewById(R.id.webevent4text);
        android1_text=rootView.findViewById(R.id.androidevent1text);
        android2_text=rootView.findViewById(R.id.androidevent2text);
        unity1_text = rootView.findViewById(R.id.gamedevent1text);
        unity2_text = rootView.findViewById(R.id.gamedevent2text);
        pythonprograming_text = rootView.findViewById(R.id.programlan1text);
        fewd = rootView.findViewById(R.id.webevent1);

        Firebase.setAndroidContext(getContext());
        fewd_url = new Firebase("https://fast-technologies.firebaseio.com/frontendwebdevelopment");
        php_url = new Firebase("https://fast-technologies.firebaseio.com/phplaravel");
        pwd_url = new Firebase("https://fast-technologies.firebaseio.com/pythonwdjango");
        aspdotnet_url= new Firebase("https://fast-technologies.firebaseio.com/aspdotnet");
        android1_url = new Firebase("https://fast-technologies.firebaseio.com/android1");
        android2_url = new Firebase("https://fast-technologies.firebaseio.com/android2");
        unity2_url = new Firebase("https://fast-technologies.firebaseio.com/unity2");
        unity1_url = new Firebase("https://fast-technologies.firebaseio.com/unity1");
        pythonprograming_url = new Firebase("https://fast-technologies.firebaseio.com/pythonprogramming");

        /*imageRef = FirebaseStorage.getInstance().getReference("gs://fast-technologies.appspot.com/home_images/pythons.png");
        final long one_megabyte = 1024 * 1024;
        imageRef.getBytes(one_megabyte).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                String pathName;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes , 0 , bytes.length);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                fewd.setMinimumHeight(displayMetrics.heightPixels);
                fewd.setMinimumWidth(displayMetrics.widthPixels);
                fewd.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });*/


        fewd_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fewd = dataSnapshot.getValue(String.class);
                fewd_text.setText(fewd);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        php_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String php = dataSnapshot.getValue(String.class);
                php_text.setText(php);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        pwd_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String pwd = dataSnapshot.getValue(String.class);
                pwd_text.setText(pwd);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        aspdotnet_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             String aspdotnet = dataSnapshot.getValue(String.class);
             aspdotnet_text.setText(aspdotnet);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        android1_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String android1 = dataSnapshot.getValue(String.class);
                android1_text.setText(android1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        android2_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String android2 = dataSnapshot.getValue(String.class);
                android2_text.setText(android2);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        unity1_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String unity1 = dataSnapshot.getValue(String.class);
                unity1_text.setText(unity1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        unity2_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String unity2 = dataSnapshot.getValue(String.class);
                unity2_text.setText(unity2);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        pythonprograming_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String python = dataSnapshot.getValue(String.class);
                pythonprograming_text.setText(python);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });





        viewFlipper();
        buttonsId(rootView);
        webDevImages(rootView);






        return rootView;
    }

    private void viewFlipper() {
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);

    }
    private void buttonsId(View rootView){
        web_dev_btn=(Button)rootView.findViewById(R.id.web_dev);
        app_dev_btn=rootView.findViewById(R.id.app_dev);
        game_dev_btn=rootView.findViewById(R.id.game_dev);
        itnsoft_btn=rootView.findViewById(R.id.itnsoft);
        graphic_disg_btn=rootView.findViewById(R.id.gra_design);
        pro_lang_btn=rootView.findViewById(R.id.pro_lang);
        net_btn=rootView.findViewById(R.id.network);
        web_dev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryWebDev.class);
                startActivity(intent);
            }
        });
        app_dev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CatgryAppDev.class);
                startActivity(intent);
            }
        });
        game_dev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryGameDev.class);
                startActivity(intent);
            }
        });
        itnsoft_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryITnSoftware.class);
                startActivity(intent);
            }
        });
        graphic_disg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryGraphicDesigning.class);
                startActivity(intent);
            }
        });
        pro_lang_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryProgLang.class);
                startActivity(intent);
            }
        });
        net_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),CategryNetworking.class);
                startActivity(intent);
            }
        });

    }
    private void webDevImages(View rootView){
        ImageView fewd,phpl,pythonDj,aspnet;
        fewd=rootView.findViewById(R.id.webevent1);
        phpl=rootView.findViewById(R.id.webevent2);
        pythonDj=rootView.findViewById(R.id.webevent3);
        aspnet=rootView.findViewById(R.id.webevent4);
        fewd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),FrontEndWebDev.class);
                startActivity(intent);
            }
        });
        phpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),PHPLaravel.class);
                startActivity(intent);
            }
        });
        pythonDj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),PythonWithDjango.class);
                startActivity(intent);
            }
        });
        aspnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ASPdotNet.class);
                startActivity(intent);
            }
        });

    }
}
