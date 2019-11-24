package com.ranjith.tmtcodingjava.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ranjith.tmtcodingjava.dataaccess.HomeDao;
import com.ranjith.tmtcodingjava.entities.Home;

@Database(entities = {Home.class}, version = 1, exportSchema = false)
public abstract class HomeDatabase  extends RoomDatabase {
    public abstract HomeDao wordDao();
    private static HomeDatabase INSTANCE;

    public static HomeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HomeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HomeDatabase.class, "word_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
