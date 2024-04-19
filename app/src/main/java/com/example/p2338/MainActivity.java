package com.example.p2338;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p2338.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    String username;
    String password; //INCREDIBLY secure, but for this application it's fine
    String userID;
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

    }

    private void getInformationFromDisplay(){
        //This is not how it was done in the videos, but this way works
        //where that one didn't.
        TextView usernameView = findViewById(R.id.usernameInput);
        TextView passwordView = findViewById(R.id.passwordInput);
        username = usernameView.getText().toString();
        System.out.println(username);
        password = passwordView.getText().toString();
        System.out.println(password);

    }
}