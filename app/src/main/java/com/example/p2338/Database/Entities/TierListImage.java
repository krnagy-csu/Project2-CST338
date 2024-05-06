package com.example.p2338.Database.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.p2338.Database.Project2Database;

import java.util.Objects;

@Entity(tableName = Project2Database.TL_IMAGE_TABLE)
public class TierListImage {
    private String imgTopic;
    private int imgID;
    @PrimaryKey @NonNull
    private String filepath;

    public TierListImage(String imgTopic, int imgID, String filepath) {
        this.imgTopic = imgTopic;
        this.imgID = imgID;
        this.filepath = filepath;
    }

    public String getImgTopic() {
        return imgTopic;
    }

    public void setImgTopic(String imgTopic) {
        this.imgTopic = imgTopic;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TierListImage that = (TierListImage) o;
        return imgID == that.imgID && Objects.equals(imgTopic, that.imgTopic) && Objects.equals(filepath, that.filepath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgTopic, imgID, filepath);
    }
}
