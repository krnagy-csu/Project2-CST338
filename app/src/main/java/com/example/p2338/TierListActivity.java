package com.example.p2338;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.p2338.Database.Entities.TierList;
import com.example.p2338.Database.Project2Repository;

import java.util.ArrayList;

public class TierListActivity extends AppCompatActivity {
    boolean isAdmin = false;
    Integer userID = 0;
    Integer topic = 0;
    Integer highlighted = 10;
    String TAG = "TIERLIST_ACTIVITY";
    ArrayList<ImageButton> tierItems = new ArrayList<ImageButton>();
    ArrayList<View> tierImages = new ArrayList<View>();
    ArrayList <ImageButton> tierBacks = new ArrayList<ImageButton>();
    private Project2Repository repository;
    String[] tiers = {"","","","","",""};
    Boolean[] placed = {false,false,false,false,false,false,false,false,false,false};
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String title;
        setContentView(R.layout.activity_tierlist);
        repository = Project2Repository.getRepository(getApplication());
        try {
            isAdmin = extras.getBoolean("Admin");
            userID = extras.getInt("ID");
        } catch (NullPointerException e) {
            Log.e(TAG, "Failed to get/set admin status and/or ID. Defaulting to &quot;false%quot;");
        }

        populateTierItems();
        populateTierImages();

        TextView titleText = findViewById(R.id.tierListTitleTextView);
        try {
            topic = extras.getInt("Topic");
        } catch (Exception e) {
            Log.e(TAG, "Failed to get topic.");
        }
        if (topic == 0) {
            title = "Placeholder";
        } else if (topic == 1) {
            title = "Topic1";
        } else if (topic == 2) {
            title = "Topic2";
        } else {
            title = "Topic3";
        }

        titleText.setText(title);

        populateTierBacks();

        Button backButton = findViewById(R.id.tierListBackButton);

        Button saveButton = findViewById(R.id.saveButton);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(goBack());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TierList savedList = new TierList(tiers[0],tiers[1],tiers[2],tiers[3],tiers[4],tiers[5]);
                savedList.setUserID(userID);
                repository.InsertTierList(savedList);
            }
        });

        for (ImageButton tierBack : tierBacks) {
            tierBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tier = tierBacks.indexOf(tierBack);
                    Log.i(TAG,"Pressed button for the " + tier + " tier");
                    if (highlighted != 10){
                        if (!placed[highlighted]) {
                            tiers[tier] += String.format("%s", highlighted);
                            placed[highlighted] = true;
                            ImageButton target = tierItems.get(highlighted);
                            target.setX(v.getX()-150f + (tiers[tier].length() * 180f));
                            target.setY(v.getY()+25);
                            highlighted = 10;
                        }
                    }
                    Log.i(TAG,"Tier " + tier + " is now " + tiers[tier]);
                }
            });
        }

        for (ImageButton tierItem : tierItems){
            tierItem.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int item = tierItems.indexOf(tierItem);
                    Log.i(TAG,"Pressed the " + item + " item");
                    if (!placed[item]) {
                        highlighted = item;
                    }
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) v.getLayoutParams();
                    ConstraintSet c = new ConstraintSet();
                    // c.clone(TierListActivity.this,tierItem.getId());
                }
            });
        }

    }

    private void populateTierItems(){
        
        tierItems.add(0,findViewById(R.id.TLItem0));
        tierItems.add(1,findViewById(R.id.TLItem1));
        tierItems.add(2,findViewById(R.id.TLItem2));
        tierItems.add(3,findViewById(R.id.TLItem3));
        tierItems.add(4,findViewById(R.id.TLItem4));
        tierItems.add(5,findViewById(R.id.TLItem5));
        tierItems.add(6,findViewById(R.id.TLItem6));
        tierItems.add(7,findViewById(R.id.TLItem7));
        tierItems.add(8,findViewById(R.id.TLItem8));
        tierItems.add(9,findViewById(R.id.TLItem9));
         
    }

    private void populateTierImages(){
        tierImages.add(0,findViewById(R.id.tierSimg));
        tierImages.add(1,findViewById(R.id.tierAimg));
        tierImages.add(2,findViewById(R.id.tierBimg));
        tierImages.add(3,findViewById(R.id.tierCimg));
        tierImages.add(4,findViewById(R.id.tierDimg));
        tierImages.add(5,findViewById(R.id.tierFimg));
    }

    private void populateTierBacks(){
        tierBacks.add(0,findViewById(R.id.bgStier));
        tierBacks.add(1,findViewById(R.id.bgAtier));
        tierBacks.add(2,findViewById(R.id.bgBtier));
        tierBacks.add(3,findViewById(R.id.bgCtier));
        tierBacks.add(4,findViewById(R.id.bgDtier));
        tierBacks.add(5,findViewById(R.id.bgFtier));
    }

    private Intent goBack(){
        Intent i = new Intent(TierListActivity.this,TopicSelectionActivity.class);
        i.putExtra("Admin",isAdmin);
        i.putExtra("ID",userID);
        return i;
    }
}
