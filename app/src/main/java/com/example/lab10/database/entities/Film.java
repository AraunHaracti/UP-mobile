package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "film",
        foreignKeys = {
                @ForeignKey(entity = Genre.class, parentColumns = "id", childColumns = "genre_id"),
                @ForeignKey(entity = Country.class, parentColumns = "id", childColumns = "country_id")},
        indices = {
                @Index(value = "genre_id"),
                @Index(value = "country_id")})
public class Film {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name="genre_id")
    public int genreId;

    @ColumnInfo(name="country_id")
    public int countryId;
}
