package com.example.musicplayer;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

abstract class DoubleClickListener1 implements View.OnClickListener {
    private static final long DOUBLE_TIME = 1000;
    private static long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < DOUBLE_TIME) {
            onDoubleClick(v);
        }
        lastClickTime = currentTimeMillis;
    }

    public abstract void onDoubleClick(View v);
}

public class MovieActivity extends AppCompatActivity{
    private SoundPool soundPoolt;
    private int soundIDt;
    private MediaPlayer music;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initSoundt();
        Button tai = (Button) findViewById(R.id.tai);
        tai.setOnClickListener(new DoubleClickListener1() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent = new Intent(MovieActivity.this, TaiActivity.class);
                startActivity(intent);
                playSoundt();
            }
        });


    }

    private void initSoundt() {
        soundPoolt = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundIDt =soundPoolt .load(this, R.raw.tai, 1);

    }

    private void playSoundt() {
        soundPoolt.play(
                soundIDt,0.5f,0.5f,0,0,1
        );}

    }