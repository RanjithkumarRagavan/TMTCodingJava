package com.ranjith.tmtcodingjava.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                           // .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    /**
     * Populate the database in the background.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final HomeDao mDao;
        String[] words = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(HomeDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate the database
            // when it is first created
           // mDao.deleteAll();

            /*(for (int i = 0; i <= words.length - 1; i++) {
                Home word = new Home(words[i]);
                mDao.insert(word);
            }*/
            return null;
        }
    }
}
