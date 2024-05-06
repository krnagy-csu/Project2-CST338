package com.example.p2338.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.p2338.Database.Project2Database;

@Entity(tableName = Project2Database.TL_IMAGE_TABLE)
public class TierListImage {
    private String imgTopic;
    private int imgID;
    @PrimaryKey
    private String filepath;

    public TierListImage(String imgTopic, int imgID, String filepath) {
        this.imgTopic = imgTopic;
        this.imgID = imgID;
        this.filepath = filepath;
    }
}
