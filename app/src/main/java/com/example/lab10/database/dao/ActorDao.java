package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.Actor;

import java.util.List;

@Dao
public interface ActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Actor actor);

    @Update
    void update(Actor actor);

    @Delete
    void delete(Actor actor);

    @Query("SELECT * FROM actor")
    List<Actor> getAllActor();
}
