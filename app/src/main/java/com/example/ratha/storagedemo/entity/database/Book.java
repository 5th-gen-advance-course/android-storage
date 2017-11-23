package com.example.ratha.storagedemo.entity.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ratha on 11/23/2017.
 */

@Entity(tableName = "book",
        foreignKeys = @ForeignKey(entity = Author.class,
                                    parentColumns = "id",
                                    childColumns ="author_id"))
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    @ColumnInfo(name = "author_id")
    private int authorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
