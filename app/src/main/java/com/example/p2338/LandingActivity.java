package com.example.p2338;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    public static final String TAG = "LANDING";

    private boolean isAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.landing_activity);
        TextView nameField = findViewById(R.id.nameTextView);
        TextView adminButton = findViewById(R.id.adminButton);
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
    }
}
