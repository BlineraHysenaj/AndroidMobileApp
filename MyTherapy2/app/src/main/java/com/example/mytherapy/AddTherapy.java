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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddTherapy extends AppCompatActivity {
Button btnAddTherapy;
EditText etName, etAge;
FirebaseAuth firebaseAuth;
FirebaseFirestore firebaseFirestore;
    String UserID, Name, Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_therapy);

//        etName = findViewById(R.id.etName);
//        etAge = findViewById(R.id.etAge);
//        btnAddTherapy = findViewById(R.id.btnAddTherapy);
//
//        firebaseAuth= FirebaseAuth.getInstance();
//        UserID= firebaseAuth.getCurrentUser().getUid();

//        btnAddTherapy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////               add personal information in firebase firestore using current user id
//                Name = etName.getText().toString();
//                Age = etAge.getText().toString();
//                Map<String,Object> UserData = new HashMap<>();
//                UserData.put("gg", Name);
//                UserData.put( "Name", etName);
//                UserData.put("Age", etAge);
//
//
//                firebaseFirestore.collection(UserID)
//                        .document()
//                        .set(UserData)  //pass map object
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//                            Toast.makeText(AddTherapy.this, "Personal information store in firebase", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Log.d("This", task.getException().getMessage());
//                        }
//
//                    }
//                }).addOnFailureListener(new OnFailureListener(){
//                    @Override
//                    public void onFailure(@NonNull Exception e){
//                        Log.d("This", e.getMessage());
//                    }
//                });
//
//
//            }
//        });
    }
}