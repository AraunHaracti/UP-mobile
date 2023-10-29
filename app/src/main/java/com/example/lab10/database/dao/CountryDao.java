package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.Country;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Country actor);

    @Update
    void update(Country actor);

    @Delete
    void delete(Country actor);

    @Query("SELECT * FROM country")
    List<Country> getAllCountry();
}
