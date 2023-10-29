package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "country")
public class Country {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;
}
