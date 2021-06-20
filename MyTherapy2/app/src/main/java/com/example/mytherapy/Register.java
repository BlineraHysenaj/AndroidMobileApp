package com.example.mytherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class Register extends AppCompatActivity {
    EditText etUsername, etPassword, etConfirmPassword;
    Button btnRegister;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        EditText etUsername, etPassword, etConfirmPassword;
//        Button btnRegister = null;
//        FirebaseAuth firebaseAuth;


        firebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this,"Mire se vini ne aplikacionin tone!", Toast.LENGTH_LONG).show();
                String email = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                            }


                        }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e){
                        Log.d("This", e.getMessage());
                    }
                });

            }
        });

//        boolean emailValidation(){
//            String email = etUsername.getText().toString();
//            if(email.isEmpty()){
//                etUsername.setError("Please enter email");
//                return false;
//
//            }else{
//                etUsername.setError(null);
//                return true;
//            }
        }
    }
