package com.example.ratha.storagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ratha.storagedemo.entity.User;
import com.example.ratha.storagedemo.utill.UserSession;

public class MainActivity extends AppCompatActivity {

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=new User(1,"Rathana","Voy","rathanavoy@gmail.com","123456");

    }

    public void onSaveUser(View view) {
        UserSession.saveUser(this,user);
    }

    public void onGetUser(View view) {
        User user =UserSession.getUserSession(this);
        Log.e("User->",user.toString());
    }

    public void onInternalStorage(View view) {

        Intent intent=new Intent(this,InternalStorageActivity.class);
        startActivity(intent);

    }

    public void onDatabaseScreen(View view) {



    }
}
