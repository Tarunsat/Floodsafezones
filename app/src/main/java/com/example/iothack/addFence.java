package com.example.iothack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addFence extends AppCompatActivity {
    Global sharedData = Global.getInstance();
    private EditText Latitude, Longitude, Radius,Level,SenID;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fence);
        Latitude = findViewById(R.id.Latitude);
        Longitude= findViewById(R.id.Longitude);
        Radius = findViewById(R.id.Radius);
        Level = findViewById(R.id.Level);
        SenID = findViewById(R.id.ID);


        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        // app_title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                String appTitle = dataSnapshot.getValue(String.class);

                // update toolbar title
                getSupportActionBar().setTitle(appTitle);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


    }
    public void Submit(View view) {
        String Lats = Latitude.getText().toString();

        String Longs = Longitude.getText().toString();

        String Rads = Radius.getText().toString();

        String Levels = Level.getText().toString();
        String ID = SenID.getText().toString();




        if (Lats.isEmpty() || Longs.isEmpty() || Rads.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all the data..", Toast.LENGTH_SHORT).show();
            return;
        }
        double rade=Double.parseDouble(Rads);
        double late=Double.parseDouble(Lats);
        double lange=Double.parseDouble(Longs);
        double Levele=Double.parseDouble(Levels);
        double senID=Double.parseDouble(ID);






        // validating if the text fields are empty or not.

        sharedData.setValueLat(late);
        sharedData.setValueLong(lange);
        sharedData.setValueRad(rade);
        sharedData.setValueLevel(Levele);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);



        // Check for already existed userId
        if (TextUtils.isEmpty(sharedData.getValueEmail())) {
            createUser(sharedData.getValueEmail(), sharedData.getValueLat(),sharedData.getValueLong(),sharedData.getValueRad(),sharedData.getValueLevel());
        } else {
            updateUser(sharedData.getValueEmail(), sharedData.getValueLat(),sharedData.getValueLong(),sharedData.getValueRad(),sharedData.getValueLevel());
        }




    }
    public void Current(View view)
    {
        Latitude.setText(String.valueOf(sharedData.getValueCurrLat()));
        Longitude.setText(String.valueOf(sharedData.getValueCurrLongs()));

    }
    public void Lastsaved(View view)
    {
        Latitude.setText(String.valueOf(sharedData.getValueCurrLat()));
        Longitude.setText(String.valueOf(sharedData.getValueCurrLongs()));

    }




    private void createUser(String email, Double Lat,Double Long,Double Rad,Double Level) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth


        User user = new User(email,Lat,Long,Rad,Level);

        mFirebaseDatabase.child(sharedData.getValueEmail()).setValue(user);


    }
    private void updateUser(String email, Double Lat,Double Long,Double Rad,Double Level) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(sharedData.getValueEmail()))
            mFirebaseDatabase.child(sharedData.getValueEmail()).child("email").setValue(email);

        mFirebaseDatabase.child(sharedData.getValueEmail()).child("Lat").setValue(Lat);
        mFirebaseDatabase.child(sharedData.getValueEmail()).child("Long").setValue(Long);
        mFirebaseDatabase.child(sharedData.getValueEmail()).child("Rad").setValue(Rad);
        mFirebaseDatabase.child(sharedData.getValueEmail()).child("Level").setValue(Level);





    }
}