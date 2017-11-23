package com.example.ratha.storagedemo;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ratha.storagedemo.entity.User;
import com.example.ratha.storagedemo.entity.database.Address;
import com.example.ratha.storagedemo.entity.database.dao.UserDao;
import com.example.ratha.storagedemo.utill.AppRoomDatabase;
import com.example.ratha.storagedemo.utill.UserSession;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    AppRoomDatabase roomDatabase;
    List<com.example.ratha.storagedemo.entity.database.User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        roomDatabase = AppRoomDatabase.getInstance(getApplicationContext());

    }

    public void onSave(View view) {
        User user= UserSession.getUserSession(this);
        com.example.ratha.storagedemo.entity.database.User  u =
                new com.example.ratha.storagedemo.entity.database.User();
        //u.setId(1);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        Address add=new Address();
        add.setZipCode("0001220");
        add.setCountry("Combodia");
        add.setStreet("265");
        u.setAddress(add);
        roomDatabase.userDao().addUser(u);


        Log.e("catagory-> ", roomDatabase.categoryDao().getAll().toString());
    }

    public void onGetUser(View view) {
        list=roomDatabase.userDao().getAll();
        printList(list);
    }

    public void printList(List<com.example.ratha.storagedemo.entity.database.User> list){

        Log.e("user List->",list.toString());

    }

    public void onRemove(View view) {
        com.example.ratha.storagedemo.entity.database.User u=new com.example.ratha.storagedemo.entity.database.User();
        u.setId(1);
        roomDatabase.userDao().removeUser(u);
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppRoomDatabase.onDestroy();
    }
}
