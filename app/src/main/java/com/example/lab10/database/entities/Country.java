package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="country")
public class Country {
    @PrimaryKey
    private long countryId;
    @ColumnInfo(name="country_name")
    public String countryName;

    public Country(){}
}
