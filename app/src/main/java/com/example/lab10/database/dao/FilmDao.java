package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.Film;

import java.util.List;

@Dao
public interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Film actor);

    @Update
    void update(Film actor);

    @Delete
    void delete(Film actor);

    @Query("SELECT * FROM film")
    List<Film> getAllFilm();
}
