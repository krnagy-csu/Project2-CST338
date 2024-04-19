package com.example.p2338.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.p2338.Database.Entities.UserDAO;
import com.example.p2338.MainActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.p2338.Database.Entities.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class Project2Database extends RoomDatabase {
    public static final String USER_TABLE = "userTable";
    private static final String DATABASE_NAME = "Project2Database";
    private static volatile Project2Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Project2Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Project2Database.class) {
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    Project2Database.class,
                                    DATABASE_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            Log.i(MainActivity.TAG,"Database created.");
            databaseWriteExecutor.execute(() -> {
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User admin = new User("admin1","admin1",true);
                dao.insert(admin);
                User testUser1 = new User("testUser1", "testUser1", false);
                dao.insert(testUser1);
            });
        }
    };

    public abstract UserDAO userDAO();
}