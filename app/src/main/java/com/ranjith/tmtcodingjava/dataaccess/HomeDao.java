package com.ranjith.tmtcodingjava.dataaccess;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ranjith.tmtcodingjava.entities.Home;

import java.util.List;

@Dao
public interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Home home);

    @Query("DELETE FROM home_table")
    void deleteAll();

    @Query("SELECT * from home_table ORDER BY home ASC")
    LiveData<List<Home>> getAllCards();
}
