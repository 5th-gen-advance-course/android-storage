package com.example.ratha.storagedemo.utill;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.ratha.storagedemo.entity.database.Address;
import com.example.ratha.storagedemo.entity.database.Author;
import com.example.ratha.storagedemo.entity.database.Book;
import com.example.ratha.storagedemo.entity.database.Category;
import com.example.ratha.storagedemo.entity.database.User;
import com.example.ratha.storagedemo.entity.database.dao.CategoryDao;
import com.example.ratha.storagedemo.entity.database.dao.UserDao;

/**
 * Created by ratha on 11/22/2017.
 */

@Database(entities = {User.class, Category.class, Author.class, Book.class}, version = 9)
public abstract class AppRoomDatabase extends RoomDatabase{
    public static final String DATABASE_NAME="DATABASE_1";
    public static int CURRENT_DATABASE_VERSION=8;
    public static int NEXT_DATABASE_VERSION=9;

    public abstract UserDao userDao();
    public abstract CategoryDao categoryDao();

    private static Context appContext;

    private static AppRoomDatabase INSTANCE;

    public static AppRoomDatabase getInstance(Context context){
        appContext=context;
        if(null ==INSTANCE){
            INSTANCE= Room.databaseBuilder(context,AppRoomDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }


    public static final Migration MIGRATION_1_2= new Migration(CURRENT_DATABASE_VERSION,NEXT_DATABASE_VERSION) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //Log.e("db-current-version-> ",database.getVersion()+"");
            database.execSQL("alter table Category add sub_category TEXT;");
        }
    };

    public static void onDestroy(){
        if(null !=INSTANCE) INSTANCE = null;
    }

}
