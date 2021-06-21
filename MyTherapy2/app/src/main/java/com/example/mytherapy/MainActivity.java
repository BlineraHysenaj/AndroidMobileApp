package com.example.mytherapy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText etUsernameLogin, etPasswordLogin;
Button btnLogin1;
Button btnRegister1;
FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsernameLogin = findViewById(R.id.etUsernameLogin);
        etPasswordLogin = findViewById(R.id.etPasswordLogin);

        btnLogin1 = findViewById(R.id.btnLogin1);
        btnRegister1 = findViewById(R.id.btnRegister1);

        firebaseAuth=FirebaseAuth.getInstance();

        etUsernameLogin.setText("bb");
        btnLogin1.setBackgroundColor(Color.YELLOW);
        btnLogin1.setTextColor(Color.BLACK);

        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Mire se vini ne aplikacionin tone!", Toast.LENGTH_LONG).show();
//                finish();
                String email = etUsernameLogin.getText().toString();
                String password = etPasswordLogin.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(MainActivity.this, AddInfo.class));
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

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                finish();
            }
        });


    }
    Boolean emailValidation(){
        String email=etUsernameLogin.getText().toString();
        if(email.isEmpty()){
            etUsernameLogin.setError("Please enter email");
            return false;

        }else{
            etUsernameLogin.setError(null);
            return true;
        }

    }
    Boolean passwordValidation(){
        String password=etPasswordLogin.getText().toString();
        if(password.isEmpty()){
            etPasswordLogin.setError("Please enter password");
            return false;

        }else{
            etPasswordLogin.setError(null);
            return true;
        }

    }


}