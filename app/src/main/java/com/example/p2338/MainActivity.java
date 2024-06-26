package com.example.p2338;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p2338.Database.Entities.User;
import com.example.p2338.Database.Entities.UserDAO;
import com.example.p2338.Database.Project2Database;
import com.example.p2338.Database.Project2Repository;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN-LOGIN";

    public static Intent loginIntent;
    private String username = "";
    private String password = ""; //INCREDIBLY secure, but for this application it's fine
    private String userID = "";

    private Project2Repository repository;

    private boolean isAdmin = false;
    //ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());

        Button btn = findViewById(R.id.signInButton);
        Button signUpBtn = findViewById(R.id.signUpButtonMainActivity);

        repository = Project2Repository.getRepository(getApplication());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                //Toast.makeText(MainActivity.this,"Username: " + username + ", Password: " + password,Toast.LENGTH_SHORT).show();
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInIntentFactory(MainActivity.this,SignUpActivity.class,"","",false);
                startActivity(loginIntent);
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

    private void logInIntentFactory(Context context, Class targetClass, String id, String uname, Boolean admin){
        loginIntent = new Intent(context, targetClass);
        loginIntent.putExtra("ID", userID);
        loginIntent.putExtra("Username",username);
        loginIntent.putExtra("Admin", isAdmin);
    }
    private void logInUser(String UN, String PW){
        //TODO: make a method for the user to log in
        if (verifyUser()) {
            logInIntentFactory(MainActivity.this,LandingActivity.class,userID,username,isAdmin);
            startActivity(loginIntent);
        }
        else {
            Toast.makeText(MainActivity.this,"Failed to log in! Incorrect name/password.",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean verifyUser(){
        ArrayList<User> users = repository.getAllUsers();
        if (users.isEmpty()){
            Log.e(TAG,"No users!");
            return false;
        }
        else {
            for (User u : users){
                if (u.getUsername().equals(username)){
                    if (u.getPassword().equals(password)){
                        isAdmin = u.getAdmin();
                        return true;
                    }
                    else {
                        Log.i(TAG,"Incorrect password!");
                        return false;
                    }
                }
            }
            Log.i(TAG,"No user " + username + " found!");
            return false;
        }
    }
}