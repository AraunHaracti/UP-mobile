package com.example.lab10.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab10.database.entities.RewardForActor;

import java.util.List;

@Dao
public interface RewardForActorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RewardForActor actor);

    @Update
    void update(RewardForActor actor);

    @Delete
    void delete(RewardForActor actor);

    @Query("SELECT * FROM reward_for_actor")
    List<RewardForActor> getAllRewardForActor();
}
