package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.Genre;

import java.util.List;

@Dao
public interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Genre actor);

    @Update
    void update(Genre actor);

    @Delete
    void delete(Genre actor);

    @Query("SELECT * FROM genre")
    List<Genre> getAllGenre();
}
