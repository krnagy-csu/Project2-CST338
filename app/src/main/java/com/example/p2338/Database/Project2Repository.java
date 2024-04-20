package com.example.p2338.Database;

import android.app.Application;
import android.util.Log;

import com.example.p2338.Database.Entities.User;
import com.example.p2338.Database.Entities.UserDAO;
import com.example.p2338.MainActivity;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Project2Repository {
    private UserDAO userDAO;
    private ArrayList<User> allUsers;

    public Project2Repository (Application application){
        Project2Database db = Project2Database.getDatabase(application);
        this.userDAO = db.userDAO();
        this.allUsers = (ArrayList<User>) this.userDAO.getAllUsers();
    }

    public static Project2Repository getRepository (Application application){
        Future<Project2Repository> future = Project2Database.databaseWriteExecutor.submit(
                new Callable<Project2Repository>() {
                    @Override
                    public Project2Repository call() throws Exception {
                        return new Project2Repository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e){
            Log.i(MainActivity.TAG, "Failed to get repository.");
            return null;
        }
    }

    public ArrayList<User> getAllUsers(){
        Future<ArrayList<User>> future = Project2Database.databaseWriteExecutor.submit(
                new Callable<ArrayList<User>>() {
                    @Override
                    public ArrayList<User> call() throws Exception {
                        return (ArrayList<User>) userDAO.getAllUsers();
                    }
                }
        );
        try{
            return future.get();
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
            Log.i(MainActivity.TAG,"Failed getting all users.");
        }
        return null;
    }

    public void insertUser (User user){
        Project2Database.databaseWriteExecutor.execute(() ->
        {
            userDAO.insert(user);
        });
    }

    public User getUserByUsername(String username) {
        Future<User> future = Project2Database.databaseWriteExecutor.submit(
                new Callable<User>() {
                    @Override
                    public User call() throws Exception {
                        return userDAO.getUserByUsername(username);
                    }
                });
        try{
            future.get();
        } catch (InterruptedException | ExecutionException e){
            Log.w(MainActivity.TAG,"Error getting user by name.");
        }
        return null;
    }
}

