package com.example.p2338.Database.Entities;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.p2338.Database.Project2Database;

import java.util.ArrayList;

public interface TierListDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertTierList (TierList... tierlist);

    @Delete
    void deleteTierList (TierList tierlist);

    @Query("Select * from " + Project2Database.TIERLIST_TABLE)
    ArrayList<TierList> selectAllTierLists();

    @Query("Select * from " + Project2Database.TIERLIST_TABLE + " where userID = :userID order by tlID")
    ArrayList<TierList> selectAllTierListsWithUID(int userID);

    @Query("Select * from " + Project2Database.TIERLIST_TABLE + " where tlID = :tlID")
    TierList selectTierListByID(int tlID);

}
