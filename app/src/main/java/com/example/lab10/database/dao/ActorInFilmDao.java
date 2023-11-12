package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.ActorInFilm;

import java.util.List;

@Dao
public interface ActorInFilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ActorInFilm actor);

    @Update
    void update(ActorInFilm actor);

    @Delete
    void delete(ActorInFilm actor);

    @Query("SELECT * FROM actor_in_film")
    List<ActorInFilm> getAllActorInFilm();

    @Query("SELECT * FROM actor_in_film WHERE actor_in_film.id = :id")
    ActorInFilm getAllActorInFilm(int id);
}
