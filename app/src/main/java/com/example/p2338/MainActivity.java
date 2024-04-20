package com.example.p2338;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p2338.Database.Entities.UserDAO;
import com.example.p2338.Database.Project2Database;
import com.example.p2338.Database.Project2Repository;
import com.example.p2338.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN-LOGIN";
    private String username = "";
    private String password = ""; //INCREDIBLY secure, but for this application it's fine
    private String userID = "";

    private boolean isAdmin = false;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        Button btn = findViewById(R.id.signInButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                Toast.makeText(MainActivity.this,"Username: " + username + ", Password: " + password,Toast.LENGTH_SHORT).show();
            }
        });

        //if

    }

    private void getInformationFromDisplay(){
        //This is not how it was done in the videos, but this way works
        //where that one didn't.
        TextView usernameView = findViewById(R.id.usernameInput);
        TextView passwordView = findViewById(R.id.passwordInput);
        username = usernameView.getText().toString();
        password = passwordView.getText().toString();
        Log.i(MainActivity.TAG, username + ", " + password);
        logInUser(username,password);

    }

    private void logInUser(String UN, String PW){
        //TODO: make a method for the user to log in
        if (true) {
            Intent loginIntent = new Intent(MainActivity.this,LandingActivity.class);
            loginIntent.putExtra("ID", userID);
            loginIntent.putExtra("Username",username);
            loginIntent.putExtra("Admin", isAdmin);
            //Log.i(TAG,i.getExtras().getString("ID"));
            startActivity(loginIntent);
        }
        else {
            Toast.makeText(MainActivity.this,"Failed to log in! Incorrect name/password.",Toast.LENGTH_SHORT).show();
        }
    }
}