package com.example.p2338.Database.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.p2338.Database.Project2Database;

import java.util.Objects;

@Entity(tableName = Project2Database.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private String password;
    private String purchases;
    private Boolean admin;
    private Integer points;

    public User(String username, String password, Boolean admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.points = 0;
        this.purchases = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPurchases() {
        return purchases;
    }

    public void setPurchases(String purchases) {
        this.purchases = purchases;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(purchases, user.purchases) && Objects.equals(admin, user.admin) && Objects.equals(points, user.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, purchases, admin, points);
    }
}
