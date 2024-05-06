package com.example.p2338.Database.Entities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.p2338.Database.Project2Database;

@Dao
public interface TierListImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImage(TierListImage img);

    @Query("Select * from " + Project2Database.TL_IMAGE_TABLE + " where imgTopic = :topic AND imgID = :id")
    TierListImage selectWithTopicAndID(String topic, int id);
}
