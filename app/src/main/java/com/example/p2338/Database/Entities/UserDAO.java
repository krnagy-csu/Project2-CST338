package com.example.p2338.Database.Entities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import com.example.p2338.Database.Project2Database;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("Select * from " + Project2Database.USER_TABLE)
    ArrayList<User> getAllRecords();

}