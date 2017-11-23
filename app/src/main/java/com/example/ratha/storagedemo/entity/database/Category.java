package com.example.ratha.storagedemo.entity.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;

/**
 * Created by ratha on 11/23/2017.
 */

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @Embedded
    private CategoryBody categoryBody;

    @ColumnInfo(name = "sub_category")
    private String subCategory;

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryBody getCategoryBody() {
        return categoryBody;
    }

    public void setCategoryBody(CategoryBody categoryBody) {
        this.categoryBody = categoryBody;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryBody=" + categoryBody +
                '}';
    }

}


