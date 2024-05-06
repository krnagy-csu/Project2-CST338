package com.example.p2338;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminOptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        Button backButton = findViewById(R.id.adminOptionsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backToMainIntent());
            }
        });
    }

    private Intent backToMainIntent(){
        Intent newIntent = new Intent(AdminOptionsActivity.this,LandingActivity.class);
        newIntent.putExtra("Admin",true);
        return newIntent;
    }
}
