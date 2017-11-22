package com.example.ratha.storagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SongListActivity extends AppCompatActivity {

    ListView lvSongList;
    List songList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lvSongList=findViewById(R.id.songList);
        songList=new ArrayList();
        for(int i=0;i<50;i++){
            songList.add("item "+i);
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                songList);
        lvSongList.setAdapter(adapter);


    }
}
