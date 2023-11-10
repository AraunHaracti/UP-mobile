package com.example.lab10.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "actor_in_film",
        foreignKeys = {
                @ForeignKey(entity = Actor.class, parentColumns = "id", childColumns = "actor_id"),
                @ForeignKey(entity = Film.class, parentColumns = "id", childColumns = "film_id")},
        indices = {
                @Index(value = "actor_id"),
                @Index(value = "film_id")})
public class ActorInFilm {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "actor_id")
    public int actorId;

    @ColumnInfo(name = "film_id")
    public int filmId;
}
