package com.example.ratha.storagedemo.entity.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ratha.storagedemo.entity.database.Category;

import java.util.List;

/**
 * Created by ratha on 11/23/2017.
 */

@Dao
public interface CategoryDao {

    @Query("select * from Category")
    List<Category> getAll();
}
