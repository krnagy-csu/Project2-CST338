package com.example.p2338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p2338.Database.Entities.UserDAO;

public class LandingActivity extends AppCompatActivity {

    public final String TAG = "LANDING";

    private boolean isAdmin;

    private static Intent mainIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.landing_activity);
        TextView nameField = findViewById(R.id.nameTextView);
        Button adminButton = findViewById(R.id.adminButton);
        Button logoutButton = findViewById(R.id.logOutButton);
        String nameString = "";
        if (extras != null) {
            Log.i(TAG,"Non-null extras");
            nameString = extras.getString("Username");
            isAdmin = extras.getBoolean("Admin");
        }
        else {
            Log.i(TAG,"Null extras");
        }
        nameField.setText(nameString);
        if (!isAdmin){
            adminButton.setVisibility(View.INVISIBLE);
        }
        else {
            adminButton.setVisibility(View.VISIBLE);
        }
        logoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                logOutIntentFactory(LandingActivity.this);
                startActivity(mainIntent);
            }
        });
        //UserDAO.getAllRecords();
    }

    private void logOutIntentFactory(Context context){
        mainIntent = new Intent(context, MainActivity.class);
    }
}
