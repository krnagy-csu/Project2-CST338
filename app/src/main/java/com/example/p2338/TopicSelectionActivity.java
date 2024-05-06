package com.example.p2338;

import android.adservices.topics.Topic;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TopicSelectionActivity extends AppCompatActivity {
    Intent topicSelIntent;
    String TAG = "TOPIC_ACTIVITY";
    boolean isAdmin = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_selection);

        try{
            isAdmin = getIntent().getExtras().getBoolean("Admin");
        } catch (NullPointerException e){
            Log.e(TAG,"Unable to get Admin status, defaulting to false.");
            isAdmin = false;
        }
        Button button1 = findViewById(R.id.bFruit);
        Button button2 = findViewById(R.id.bFastFood);
        Button button3 = findViewById(R.id.bAndroidIcons);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                topicSelIntentFactory(TopicSelectionActivity.this,1);
                startActivity(topicSelIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                topicSelIntentFactory(TopicSelectionActivity.this,2);
                startActivity(topicSelIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                topicSelIntentFactory(TopicSelectionActivity.this,3);
                startActivity(topicSelIntent);
            }
        });
    }



    private void topicSelIntentFactory (Context context, int topic){
        topicSelIntent = new Intent(context, TierListActivity.class);
        topicSelIntent.putExtra("Topic",topic);
        topicSelIntent.putExtra("Admin",isAdmin);
    }
}
