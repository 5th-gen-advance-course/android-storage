package com.example.ratha.storagedemo;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ratha.storagedemo.entity.User;
import com.example.ratha.storagedemo.entity.database.dao.UserDao;
import com.example.ratha.storagedemo.utill.AppRoomDatabase;
import com.example.ratha.storagedemo.utill.UserSession;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    AppRoomDatabase roomDatabase;
    List<com.example.ratha.storagedemo.entity.database.User> list;
    static final String DATABASE_NAME="DATABASE_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        roomDatabase= Room.databaseBuilder(getApplicationContext(), AppRoomDatabase.class,DATABASE_NAME)
                .allowMainThreadQueries()
                .build();


    }

    public void onSave(View view) {
        User user= UserSession.getUserSession(this);
        com.example.ratha.storagedemo.entity.database.User  u =
                new com.example.ratha.storagedemo.entity.database.User();
        u.setId(u.getId());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        roomDatabase.userDao().addUser(u);

    }

    public void onGetUser(View view) {
        list=roomDatabase.userDao().getAll();

    }
}
