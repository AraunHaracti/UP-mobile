package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "actor",
        foreignKeys = {
                @ForeignKey(entity = Country.class, parentColumns = "id", childColumns = "country_id")},
        indices = {
                @Index(value = "country_id")})
public class Actor {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "birthday")
    public Date birthday;

    @ColumnInfo(name = "country_id")
    public int countryId;
}
