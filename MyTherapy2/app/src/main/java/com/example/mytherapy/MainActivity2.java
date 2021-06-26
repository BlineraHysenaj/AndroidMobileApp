package com.example.mytherapy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity2 extends AppCompatActivity {
    EditText etUsername, etPassword, etConfirmPassword;
    Button btnRegister;
   FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

//        firebaseAuth.getInstance();
        firebaseAuth= firebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity2.this,"Mire se vini ne aplikacionin tone!", Toast.LENGTH_LONG).show();
                String email = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(MainActivity2.this, AddInfo.class));
                                    finish();
                                }
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
//        }
    }
}