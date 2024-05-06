package com.example.p2338.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.p2338.Database.Project2Database;

import java.util.Objects;

@Entity(tableName = Project2Database.TIERLIST_TABLE)
public class TierList {
    @PrimaryKey(autoGenerate = true)
    private int tlID;
    private int userID;
    private String tierS;
    private String tierA;
    private String tierB;
    private String tierC;
    private String tierD;
    private String tierF;
    private String topic;

    public TierList(String tierS, String tierA, String tierB, String tierC, String tierD, String tierF) {
        this.tierS = tierS;
        this.tierA = tierA;
        this.tierB = tierB;
        this.tierC = tierC;
        this.tierD = tierD;
        this.tierF = tierF;
    }

    public int getTlID() {
        return tlID;
    }

    public void setTlID(int tlID) {
        this.tlID = tlID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTierS() {
        return tierS;
    }

    public void setTierS(String tierS) {
        this.tierS = tierS;
    }

    public String getTierA() {
        return tierA;
    }

    public void setTierA(String tierA) {
        this.tierA = tierA;
    }

    public String getTierB() {
        return tierB;
    }

    public void setTierB(String tierB) {
        this.tierB = tierB;
    }

    public String getTierC() {
        return tierC;
    }

    public void setTierC(String tierC) {
        this.tierC = tierC;
    }

    public String getTierD() {
        return tierD;
    }

    public void setTierD(String tierD) {
        this.tierD = tierD;
    }

    public String getTierF() {
        return tierF;
    }

    public void setTierF(String tierF) {
        this.tierF = tierF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TierList tierList = (TierList) o;
        return tlID == tierList.tlID && userID == tierList.userID && Objects.equals(tierS, tierList.tierS) && Objects.equals(tierA, tierList.tierA) && Objects.equals(tierB, tierList.tierB) && Objects.equals(tierC, tierList.tierC) && Objects.equals(tierD, tierList.tierD) && Objects.equals(tierF, tierList.tierF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tlID, userID, tierS, tierA, tierB, tierC, tierD, tierF);
    }
}
