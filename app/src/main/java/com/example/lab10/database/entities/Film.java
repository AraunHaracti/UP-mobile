package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName="film",
        foreignKeys = {
        @ForeignKey(entity = Genre.class, parentColumns = "genre_id", childColumns = "genre_id"),
        @ForeignKey(entity = Country.class, parentColumns = "country_id", childColumns = "country_id")},
        indices = {
        @Index(value="genre_id"),
        @Index(value="country_id")})
public class Film {
    @PrimaryKey
    private long filmId;
    @ColumnInfo(name="film_name")
    public String filmName;
    @ColumnInfo(name="film_date")
    public Date filmDate;
    @ColumnInfo(name="genre_id")
    public long genreId;
    @ColumnInfo(name="country_id")
    public long countryId;

    public Film(){}

}
