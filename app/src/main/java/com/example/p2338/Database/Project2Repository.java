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
        this.allUsers = this.userDAO.getAllRecords();
    }

    public ArrayList<User> getAllUsers(){
        Future<ArrayList<User>> future = Project2Database.databaseWriteExecutor.submit(
                new Callable<ArrayList<User>>() {
                    @Override
                    public ArrayList<User> call() throws Exception {
                        return userDAO.getAllRecords();
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

}

