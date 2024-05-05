package com.example.p2338;

import static androidx.core.view.ViewCompat.startDragAndDrop;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import java.util.ArrayList;

public class TierListActivity extends AppCompatActivity {
    boolean isAdmin = false;
    Integer topic = 0;
    String TAG = "TIERLIST_ACTIVITY";
    ArrayList<View> draggables = new ArrayList<View>();
    ArrayList<View> tierImages = new ArrayList<View>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String title;

        setContentView(R.layout.activity_tierlist);
        try {
            isAdmin = extras.getBoolean("Admin");
        } catch (NullPointerException e) {
            Log.e(TAG, "Failed to get/set admin status. Defaulting to &quot;false%quot;");
        }

        populateDraggables();
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

        for (View v : draggables){
            v.setActivated(true);
            v.setVisibility(View.VISIBLE);
        }



        DragStartHelper.OnDragStartListener listener = new DragStartHelper.OnDragStartListener() {
            @Override
            public boolean onDragStart(@NonNull View v, @NonNull DragStartHelper helper) {
                return false;
            }
        };
    }

    private void populateDraggables(){
        /*
        draggables.add(findViewById(R.id.TLDraggable1));
        draggables.add(findViewById(R.id.TLDraggable2));
        draggables.add(findViewById(R.id.TLDraggable3));
        draggables.add(findViewById(R.id.TLDraggable4));
        draggables.add(findViewById(R.id.TLDraggable5));
        draggables.add(findViewById(R.id.TLDraggable6));
        draggables.add(findViewById(R.id.TLDraggable7));
        draggables.add(findViewById(R.id.TLDraggable8));
        draggables.add(findViewById(R.id.TLDraggable9));
        draggables.add(findViewById(R.id.TLDraggable10);
         */
    }

    private void populateTierImages(){
        tierImages.add(findViewById(R.id.tierSimg));
        tierImages.add(findViewById(R.id.tierAimg));
        tierImages.add(findViewById(R.id.tierBimg));
        tierImages.add(findViewById(R.id.tierCimg));
        tierImages.add(findViewById(R.id.tierDimg));
        tierImages.add(findViewById(R.id.tierFimg));
    }
}
