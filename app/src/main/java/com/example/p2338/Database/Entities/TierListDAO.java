package com.example.p2338.Database.Entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.p2338.Database.Project2Database;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TierListDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void insertTierList (TierList... tierlist);

    @Delete
    public void deleteTierList (TierList tierlist);

    @Query("Select * from " + Project2Database.TIERLIST_TABLE)
    public List<TierList> selectAllTierLists();

    @Query("Select * from " + Project2Database.TIERLIST_TABLE + " where userID = :userID order by tlID")
    public List<TierList> selectAllTierListsWithUID(int userID);

    @Query("Select * from " + Project2Database.TIERLIST_TABLE + " where tlID = :tlID")
    public TierList selectTierListByID(int tlID);

}
