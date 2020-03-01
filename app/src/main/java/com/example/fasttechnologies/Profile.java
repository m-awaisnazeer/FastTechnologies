package com.example.fasttechnologies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends Fragment {
    ImageView imageView;
    TextView userEmail,share,contact,visit,rate,Username;
    TextView Signout;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseAuth.AuthStateListener authStateListener;
    String mapadrress="26/27-M Civic Center  Model Town Lahore,Punjab 54000";
    ProgressBar progressBar;
    Firebase name_url;
    String uid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.profile,container,false);
        imageView=rootView.findViewById(R.id.image11);
        Username=rootView.findViewById(R.id.username);
        Signout=rootView.findViewById(R.id.logout);
        share=rootView.findViewById(R.id.share);
        contact=rootView.findViewById(R.id.contactus);
        visit=rootView.findViewById(R.id.visitus);
        rate=rootView.findViewById(R.id.rateus);
        userEmail = rootView.findViewById(R.id.useremail);
        progressBar=rootView.findViewById(R.id.progressbarlogout);
        firebaseAuth= FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        name_url = new Firebase("https://fast-technologies.firebaseio.com/All Users/"+uid+"/name");
        //name_url = new Firebase("https://fast-technologies.firebaseio.com/All Users/zone1UpiBHXvj923NhH1uLZy27g2/name");
        Firebase.setAndroidContext(getContext());
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Share", Toast.LENGTH_SHORT).show();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Contact Us", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(),ContactUs.class));

            }
        });
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri Gmintent = Uri.parse("geo:0,0?q="+mapadrress);
                Intent mapintent = new Intent(Intent.ACTION_VIEW,Gmintent);
                mapintent.setPackage("com.google.android.apps.maps");
                startActivity(mapintent);
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Rate Us", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), uid, Toast.LENGTH_SHORT).show();

            }
        });

        name_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                Username.setText(name);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        uid = firebaseUser.getUid();

        userEmail.setText(firebaseUser.getEmail());

        name_url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                Username.setText(name);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser == null){
                    //startActivity(new Intent(getContext(),StartActivity.class));
                    getActivity().finish();


                }
            }
        };
        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                //FirebaseAuth.getInstance().signOut();
                //startActivity(new Intent(getContext(),StartActivity.class));
                signout();
            }
        });




        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener!=null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    public void signout(){
        progressBar.setVisibility(View.GONE);
        firebaseAuth.signOut();
    }
}
