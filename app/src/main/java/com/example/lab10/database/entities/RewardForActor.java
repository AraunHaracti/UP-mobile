package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "reward_for_actor",
        foreignKeys = {
                @ForeignKey(entity = Actor.class, parentColumns = "id", childColumns = "actor_id"),
                @ForeignKey(entity = Reward.class, parentColumns = "id", childColumns = "reward_id")},
        indices = {
                @Index(value = "actor_id"),
                @Index(value = "reward_id")})
public class RewardForActor {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "actor_id")
    public int actorId;

    @ColumnInfo(name = "reward_id")
    public int rewardId;

    public RewardForActor(int actorId, int rewardId){
        this.actorId = actorId;
        this.rewardId = rewardId;
    }
}
