package com.example.ratha.storagedemo.utill;

import android.arch.persistence.room.RoomDatabase;

import com.example.ratha.storagedemo.entity.database.dao.UserDao;

/**
 * Created by ratha on 11/22/2017.
 */

public abstract class AppRoomDatabase extends RoomDatabase{
    public abstract UserDao userDao();

}
