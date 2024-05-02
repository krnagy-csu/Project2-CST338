package com.example.p2338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.p2338.Database.Entities.User;
import com.example.p2338.Database.Project2Repository;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG = "MAIN-SIGNUP";

    public static Intent signupIntent;

    private String errMsg = "";

    private Project2Repository repository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btn = findViewById(R.id.signUpButtonSignUpActivity);

        repository = Project2Repository.getRepository(getApplication());

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (createNewUser()){
                    Toast.makeText(SignUpActivity.this,"Success!",Toast.LENGTH_SHORT).show();
                    signUpIntentFactory(SignUpActivity.this);
                    startActivity(signupIntent);
                }
                else {
                    Toast.makeText(SignUpActivity.this,errMsg,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean createNewUser(){
        String username;
        String password;
        TextView usernameInput = findViewById(R.id.usernameSignupInput);
        TextView passwordInput = findViewById(R.id.passwordSignupInput);
        TextView passwordConfirm = findViewById(R.id.passwordSignupConfirm);
        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        if (username.isEmpty()){
            errMsg = "Username must not be empty.";
            return false;
        }
        if (password.isEmpty()){
            errMsg = "Password must not be empty.";
            return false;
        }
        if (!(passwordConfirm.getText().toString()).equals(password)){
            errMsg = "Passwords do not match.";
            passwordInput.getEditableText().clear();
            passwordConfirm.getEditableText().clear();
            return false;
        }
        else {
            User newUser = new User(username,password,false);
            ArrayList<User> users = repository.getAllUsers();
            for (User u : users){
                if (u.getUsername().equals(newUser.getUsername())){
                    errMsg = "Unable to add user; name already exists!";
                    return false;
                }
            }
            try {
                repository.insertUser(newUser);
                return true;
            } catch (Exception e){
                errMsg = "Something went wrong.";
                return false;
            }
        }
    }

    private void signUpIntentFactory(Context context){
        signupIntent = new Intent(context,MainActivity.class);
    }
}
