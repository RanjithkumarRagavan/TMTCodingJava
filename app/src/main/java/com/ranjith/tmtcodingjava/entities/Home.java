package com.ranjith.tmtcodingjava.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "home_table")
public class Home {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "home")
    private String home;

    public Home(@NonNull String home) {this.home = home;}

    public String getHome(){return this.home;}
}
