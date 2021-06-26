package com.example.mytherapy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
public class AddInfo extends AppCompatActivity {
//    Button btnAddTherapy;
//    EditText etName, etAge;
//    FirebaseAuth firebaseAuth;
//    FirebaseFirestore firebaseFirestore;
//    String UserID, Name, Age;




    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    TextView info;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);


        info = (TextView)findViewById(R.id.info);
        pickerDate = (DatePicker)findViewById(R.id.pickerdate);
        pickerTime = (TimePicker)findViewById(R.id.pickertime);

        Calendar now = Calendar.getInstance();

        pickerDate.init(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

        buttonSetAlarm = (Button)findViewById(R.id.setalarm);
        buttonSetAlarm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Calendar current = Calendar.getInstance();

                Calendar cal = Calendar.getInstance();
                cal.set(pickerDate.getYear(),
                        pickerDate.getMonth(),
                        pickerDate.getDayOfMonth(),
                        pickerTime.getCurrentHour(),
                        pickerTime.getCurrentMinute(),
                        00);

                if(cal.compareTo(current) <= 0){
                    //The set Date/Time already passed
                    Toast.makeText(getApplicationContext(),
                            "Invalid Date/Time",
                            Toast.LENGTH_LONG).show();
                }else{
                    setAlarm(cal);
                }

            }});
    }
    private void setAlarm(Calendar targetCal){

        info.setText("\n\n***\n"
                + "Alarm is set@ " + targetCal.getTime() + "\n"
                + "***\n");

        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

//
//        textAlarmPrompt = (TextView)findViewById(R.id.alarmprompt);
//
//        buttonstartSetDialog = (Button)findViewById(R.id.startSetDialog);
//        buttonstartSetDialog.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                textAlarmPrompt.setText("");
//                openTimePickerDialog(false);
//
//            }});
//
//    }
//
//
//    private void openTimePickerDialog(boolean is24r){
//        Calendar calendar = Calendar.getInstance();
//
//        timePickerDialog = new TimePickerDialog(
//                AddInfo.this,
//                onTimeSetListener,
//                calendar.get(Calendar.HOUR_OF_DAY),
//                calendar.get(Calendar.MINUTE),
//                is24r);
//        timePickerDialog.setTitle("Set Alarm Time");
//
//        timePickerDialog.show();
//
//    }
//
//    TimePickerDialog.OnTimeSetListener onTimeSetListener
//            = new TimePickerDialog.OnTimeSetListener() {
//
////        @RequiresApi(api = Build.VERSION_CODES.M)
//        @Override
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//            Calendar calNow = Calendar.getInstance();
//            Calendar calSet = (Calendar) calNow.clone();
//
//            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
//            calSet.set(Calendar.MINUTE, minute);
//            calSet.set(Calendar.SECOND, 0);
//            calSet.set(Calendar.MILLISECOND, 0);
//
//            if(calSet.compareTo(calNow) <= 0){
//                //Today Set time passed, count to tomorrow
//                calSet.add(Calendar.DATE, 1);
//            }
//
//            setAlarm(calSet);
//        }};
//
////    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void setAlarm(Calendar targetCal){
//
//        textAlarmPrompt.setText(
//                "\n\n***\n"
//                        + "Alarm is set@ " + targetCal.getTime() + "\n"
//                        + "***\n");
//
//        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
//        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
//
//    }
        
//        etName = findViewById(R.id.etName);
//        etAge = findViewById(R.id.etAge);
//        btnAddTherapy = findViewById(R.id.btnAddTherapy);
//
//        firebaseAuth= FirebaseAuth.getInstance();
//        UserID= firebaseAuth.getCurrentUser().getUid();
//
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
////                            Toast.makeText(AddInfo.this, "Personal information store in firebase", Toast.LENGTH_SHORT).show();
//                            if(task.isSuccessful()){
//                                startActivity(new Intent(AddInfo.this, AddTherapy.class));
//                                finish();
//                            }
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
//    }
}