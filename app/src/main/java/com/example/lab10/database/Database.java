package com.example.lab10.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab10.database.dao.ActorDao;
import com.example.lab10.database.dao.ActorInFilmDao;
import com.example.lab10.database.dao.CountryDao;
import com.example.lab10.database.dao.FilmDao;
import com.example.lab10.database.dao.GenreDao;
import com.example.lab10.database.dao.RewardDao;
import com.example.lab10.database.dao.RewardForActorDao;
import com.example.lab10.database.entities.Actor;
import com.example.lab10.database.entities.ActorInFilm;
import com.example.lab10.database.entities.Country;
import com.example.lab10.database.entities.Film;
import com.example.lab10.database.entities.Genre;
import com.example.lab10.database.entities.Reward;
import com.example.lab10.database.entities.RewardForActor;

@androidx.room.Database(entities = {
            Actor.class,
            ActorInFilm.class,
            Country.class,
            Film.class,
            Genre.class,
            Reward.class,
            RewardForActor.class},
        version = 2)
public abstract class Database extends RoomDatabase {
    public abstract ActorDao actorDao();
    public abstract ActorInFilmDao actorInFilmDao();
    public abstract CountryDao countryDao();
    public abstract FilmDao filmDao();
    public abstract GenreDao genreDao();
    public abstract RewardDao rewardDao();
    public abstract RewardForActorDao rewardForActorDao();

    public static Database INSTANCE;
    public static Database getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            Database.class,
                            "test_database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}
