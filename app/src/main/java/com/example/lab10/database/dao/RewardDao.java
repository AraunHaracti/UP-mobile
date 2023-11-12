package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.Reward;

import java.util.List;

@Dao
public interface RewardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Reward actor);

    @Update
    void update(Reward actor);

    @Delete
    void delete(Reward actor);

    @Query("SELECT * FROM reward")
    List<Reward> getAllReward();

    @Query("SELECT * FROM reward WHERE reward.id = :id")
    Reward getReward(int id);
}
