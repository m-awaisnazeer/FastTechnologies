package com.example.fasttechnologies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextInputLayout email,passwd,fullname,phoneNum;
    TextView signup;
    FirebaseAuth firebaseAuth;
    DatabaseReference Dr;
    String emails,passwords,usernames,phoneNumbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressBar=findViewById(R.id.progressbar);
        email=findViewById(R.id.email_inputlayout);
        passwd=findViewById(R.id.password_inputlayout);
        fullname=findViewById(R.id.username_inputlayout);
        phoneNum=findViewById(R.id.phone_inputlayout);
        signup=findViewById(R.id.btn_signup);
       firebaseAuth = FirebaseAuth.getInstance();
        Dr = FirebaseDatabase.getInstance().getReference().child("All Users");


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(email.getEditText().getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Please Fill all Empty Filleds", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwd.getEditText().getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Please Fill all Empty Filleds", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(phoneNum.getEditText().getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Please Fill all Empty Filleds", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fullname.getEditText().getText().toString().trim())){
                    Toast.makeText(RegisterActivity.this, "Please Fill all Empty Filleds", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getEditText().getText().toString().trim(),passwd.getEditText().getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()){
                            String userId = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference current_user = Dr.child(userId);
                            current_user.child("email").setValue(email.getEditText().getText().toString().trim());
                            current_user.child("password").setValue(passwd.getEditText().getText().toString().trim());
                            current_user.child("name").setValue(fullname.getEditText().getText().toString().trim());
                            current_user.child("PhoneNumber").setValue(phoneNum.getEditText().getText().toString().trim());
                            firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Register Successfully. Please check your email for verification", Toast.LENGTH_SHORT).show();

                                    }else {
                                        Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage()  , Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
