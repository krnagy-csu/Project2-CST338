package com.example.p2338.Database.Entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;
import com.example.p2338.Database.Entities.User;
import com.example.p2338.Database.Project2Database;
import com.example.p2338.Database.Project2Repository;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + Project2Database.USER_TABLE + " ORDER BY username")
    List<User>getAllUsersOrdered();

    @Query("Select * from " + Project2Database.USER_TABLE)
    List<User> getAllUsers();

    @Query("DELETE from " + Project2Database.USER_TABLE)
    void deleteAll();

    @Query("SELECT * from " + Project2Database.USER_TABLE + " WHERE username == :userName")
    User getUserByUsername(String userName);

    @Query("SELECT * from " + Project2Database.USER_TABLE + " WHERE userID == :userID")
    User getUserByID (int userID);

}