package com.example.ratha.storagedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ratha.storagedemo.entity.User;
import com.example.ratha.storagedemo.utill.UserSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {

    static final String FILE_NAME="USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

    }

    public void onGetData(View view) {
        try {
            FileInputStream fis=this.openFileInput(FILE_NAME);
            String data="";
            int c=0;
            while ( (c=fis.read()) !=  -1){
                data=data+ (char)c;
            }
            Log.e("read->",data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onSaveData(View view) {

        User user = UserSession.getUserSession(this);
        FileOutputStream fos=null;
        try {
            fos=this.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write((user.getId() + "").getBytes());
            fos.write(user.getFirstName().getBytes());
            fos.write(user.getLastName().getBytes());
            fos.write(user.getEmail().getBytes());
            fos.write(user.getPassword().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
