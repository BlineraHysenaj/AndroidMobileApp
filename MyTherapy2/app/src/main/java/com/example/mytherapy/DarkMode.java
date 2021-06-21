package com.example.mytherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class DarkMode extends AppCompatActivity {
private Switch aSwitch;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_DarkTheme);
    } else{
        setTheme(R.style.Theme_MyTherapy);
    }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_mode);
//        aSwitch=findViewById(R.id.activity_dark_mode);
        textView=findViewById(R.id.t1);

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            aSwitch.setChecked(true);
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                reset();
                textView.setText("Dark Mode" );
                reset();}
                 else
                {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                textView.setText("Light Mode" );
                reset();}
            }

        });


    }
    private void reset(){
        Intent intent=new Intent(getApplicationContext(),DarkMode.class);
       startActivity(intent);
       finish();


    }
}