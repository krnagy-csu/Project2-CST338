package com.example.p2338;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.p2338.Database.Entities.TierList;
import com.example.p2338.Database.Project2Repository;

import java.util.ArrayList;

/**
 * Inoperative due to database problems; not enough time to fix.
 */


public class ViewLists extends AppCompatActivity {
    private Project2Repository repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_lists);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        repo = Project2Repository.getRepository(getApplication());
        ArrayList<TierList> tierLists = null;
        try{
            tierLists = repo.GetAllTierLists();
        } catch (Exception e){
            Log.e("VIEWACTIVITY",e.toString());
        }
        if (tierLists != null){
            if (!tierLists.isEmpty()){
                for (int i = tierLists.size()-1; i >= (Math.max(0,tierLists.size()-10));){
                    TextView tv = new TextView(ViewLists.this);
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("S-tier : %s%n", tierLists.get(i).getTierS()));
                    sb.append(String.format("A-tier : %s%n", tierLists.get(i).getTierA()));
                    sb.append(String.format("B-tier : %s%n", tierLists.get(i).getTierB()));
                    sb.append(String.format("C-tier : %s%n", tierLists.get(i).getTierC()));
                    sb.append(String.format("D-tier : %s%n", tierLists.get(i).getTierD()));
                    sb.append(String.format("F-tier : %s%n", tierLists.get(i).getTierF()));
                    tv.setText(sb.toString());
                    tv.setX(200);
                    tv.setY(200 * (i-(Math.max(0,tierLists.size()))));

                    Log.i("VIEWLISTS","Attempted display.");
                }
            } else{
                Log.w("VIEWLISTS","Empty arraylist of tierlists.");
            }
        } else{
            Log.w("VIEWLISTS","Null arraylist of tierlists.");
        }

        Button backButton = findViewById(R.id.viewListsBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(viewListsIntentFactory());
            }
        });
    }

    private Intent viewListsIntentFactory(){
        return new Intent(ViewLists.this, LandingActivity.class);
    }
}