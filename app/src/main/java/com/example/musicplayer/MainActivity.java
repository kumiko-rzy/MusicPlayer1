package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

abstract class DoubleClickListener implements View.OnClickListener {
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

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool1;
    private int soundID1;
    private SoundPool soundPool2;
    private int soundID2;
    private SoundPool soundPool3;
    private int soundID3;
    private SoundPool soundPool4;
    private int soundID4;
    private MediaPlayer music;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSound1();
        initSound2();
        initSound3();
        initSound4();

        Button movie = (Button)findViewById(R.id.movie);
        Button music=(Button)findViewById((R.id.music));
        Button book=(Button)findViewById((R.id.book));
        Button my=(Button)findViewById((R.id.my));

        movie.setOnClickListener(new DoubleClickListener(){
            @Override
            public void onDoubleClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,MovieActivity.class);
                startActivity(intent1);
                playSound1();
            }
        });
        music.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,MusicActivity.class);
                startActivity(intent2);
                playSound2();
            }
        });
       book.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,BookActivity.class);
                startActivity(intent3);
                playSound3();
            }
        });
        my.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                Intent intent4 = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent4);
                playSound4();
            }
        });
    }

    private void initSound1() {
        soundPool1 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID1 =soundPool1 .load(this, R.raw.dianying, 1);

    }
    private void initSound2() {
        soundPool2 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID2 =soundPool2 .load(this, R.raw.yinyue, 1);

    }
    private void initSound3() {
        soundPool3 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID3 =soundPool3 .load(this, R.raw.tingshu, 1);

    }
    private void initSound4() {
        soundPool4 = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundID4 =soundPool4 .load(this, R.raw.wodeshoucang, 1);

    }
    private void playSound1() {
        soundPool1.play(
                soundID1,0.5f,0.5f,0,0,1
        );}

    private void playSound2() {
        soundPool2.play(
                soundID2,0.5f,0.5f,0,0,1
        );}

    private void playSound3() {
        soundPool3.play(
                soundID3,0.5f,0.5f,0,0,1
        );}
    private void playSound4() {
        soundPool4.play(
                soundID4,0.5f,0.5f,0,0,1
        );}
}