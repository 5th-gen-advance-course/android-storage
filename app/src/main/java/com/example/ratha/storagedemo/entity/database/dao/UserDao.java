package com.example.ratha.storagedemo.entity.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ratha.storagedemo.entity.database.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> getAll();
    @Insert
    void addUser(User user);
    @Update
    void editUser(User user);
    @Delete void removeUser(User user);
}
