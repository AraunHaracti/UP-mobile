package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="genre")
public class Genre {
    @PrimaryKey
    private long genreId;
    @ColumnInfo(name="genre_name")
    public String genreName;

    public Genre(){}
}
